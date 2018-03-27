package com.massivecraft.factions.listeners;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.event.FLevelsEvents.FactionGainedPointsEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import subside.plugins.koth.events.KothEndEvent;
import subside.plugins.koth.gamemodes.RunningKoth;

public class KothWinListener implements Listener {

    @EventHandler
    public void onKothWin(KothEndEvent e){
        if(e.getReason().equals(RunningKoth.EndReason.WON)){
            Faction faction = Factions.getInstance().getByTag(e.getWinner().getName());
            faction.addKothWin();
            faction.addLevelPoints(15);
            faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> Tu faccion ha ganado el koth, ganais &d&l15 &ePuntos de nivel!");
            FactionGainedPointsEvent event = new FactionGainedPointsEvent(faction,15);
            Bukkit.getServer().getPluginManager().callEvent(event);
        }
    }

}
