package com.massivecraft.factions.listeners;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import subside.plugins.koth.captureentities.Capper;
import subside.plugins.koth.events.KothCapEvent;
import subside.plugins.koth.events.KothEndEvent;
import subside.plugins.koth.events.KothStartEvent;
import subside.plugins.koth.gamemodes.RunningKoth;

public class KothWinListener implements Listener {


    private boolean isKothRunning = false;
    private Capper actualCapper;
    private String kothName;

    @EventHandler
    public void onKothStart(KothStartEvent e){
        isKothRunning = true;
        kothName = e.getKoth().getName();
    }

    @EventHandler
    public void onKothCapEvent(KothCapEvent e){
        actualCapper = e.getNextCapper();
    }

    @EventHandler
    public void onKothWin(KothEndEvent e){
        if(e.getReason().equals(RunningKoth.EndReason.WON)){
            Faction faction = Factions.getInstance().getByTag(e.getWinner().getName());
            faction.addKothWin();
            faction.addLevelPoints(15);
            faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> Tu faccion ha ganado el koth, ganais &d&l15 &ePuntos de nivel!");
        }
        isKothRunning = false;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){

        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(e.getEntity());
        if(fPlayer.hasFaction()){

            FPlayer killer = FPlayers.getInstance().getByPlayer(e.getEntity().getKiller());
            Faction faction = fPlayer.getFaction();
            Faction killerFaction = killer.getFaction();

            if(isKothRunning){
                Faction controllingFaction = Factions.getInstance().getByTag(actualCapper.getName());
                if(controllingFaction.getTag().equals(faction.getTag())){

                    faction.broadCastMessage("&c&l" + faction.getTag() + "&7>&8> El jugador &c&l" + fPlayer.getName() + "&8 ha muerto en combate mientras capeabais el koth &e&l"+kothName+"! &8Perdeis &c&l15 &8puntos de nivel!");
                    if(transferPoints(fPlayer,killer,15)) {

                        killerFaction.broadCastMessage("&a&l" + killerFaction.getTag() + "&7>&8> El jugador &a&l" + killer.getName() + "&8 ha matado a &c&l" + fPlayer.getName() + " &8 mientras capeaba el koth! Ganais &a&l15 &8puntos de nivel!");
                        return;
                    }

                }

            }

            faction.broadCastMessage("&c&l" + faction.getTag() + "&7>&8> El jugador &c&l" + fPlayer.getName() + "&8 ha muerto en combate! Perdeis &c&l5 &8puntos de nivel!");

            if(transferPoints(fPlayer,killer,5)) {

                killerFaction.broadCastMessage("&a&l" + killerFaction.getTag() + "&7>&8> El jugador &a&l" + killer.getName() + "&8 ha matado a &c&l" + fPlayer.getName() + "&8! Ganais &a&l5 &8puntos de nivel!");

            }
        }

    }



    private boolean transferPoints(FPlayer facFrom, FPlayer facTo, int points){

        if(facFrom.getLevelPoints()<=0) {
            facFrom.takeLevelPoints(points);
            return false;
        }
        facFrom.takeLevelPoints(points);
        facTo.takeLevelPoints(points);
        return true;
    }

}
