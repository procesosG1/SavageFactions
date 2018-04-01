package com.massivecraft.factions.zcore.FLevelPrestiges;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FLevelsEvents.FactionGainedPointsEvent;
import com.massivecraft.factions.event.FLevelsEvents.FactionLevelDownEvent;
import com.massivecraft.factions.event.FLevelsEvents.FactionLevelUpevent;
import com.massivecraft.factions.event.FLevelsEvents.FactionLostLevelPoints;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.event.FPlayerLeaveEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FLevelPrestigesListener implements Listener {

    @EventHandler
    public void onFactionPlayerJoin(FPlayerJoinEvent e){
        Faction faction = e.getFaction();
        faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> El jugador &a&l" + e.getfPlayer().getName() + " &8se ha unido a tu faccion, ganais &d&l5 &ePuntos de nivel!");
        e.getfPlayer().addLevelPoints(5);
    }

    @EventHandler
    public void onFactionPlayerLeave(FPlayerLeaveEvent e){
        Faction faction = e.getFaction();
        faction.broadCastMessage("&c&l" + faction.getTag() + "&7>&8> El jugador &c&l" + e.getfPlayer().getName() + " &8se ha salido de tu faccion, perdeis &d&l5 &ePuntos de nivel!");
        e.getfPlayer().takeLevelPoints(5);
    }


    @EventHandler
    public void onFactionGainedPoints(FactionGainedPointsEvent e){

        Faction faction = e.getFaction();
        Level level = faction.getLevel();
        int levelPoints = faction.getLevelPoints();

        if(faction.isMaxPrestige() && faction.isMaxLevel())
            return;

        if(levelPoints > level.getPoints())
            faction.levelUp();

    }


    @EventHandler
    public void onFactionLostPoints(FactionLostLevelPoints e){
        Faction faction = e.getFaction();
        Level level = faction.getLevel();
        int levelPoints = faction.getLevelPoints();

        if(faction.isMinLevel() && faction.isMinPrestige())
            return;

        if(levelPoints < level.getPoints())
            faction.levelDown();
    }


    @EventHandler
    public void onFactionLevelUp(FactionLevelUpevent e){
        Faction faction = e.getFaction();

        faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> Tu faccion ha subido de nivel, ahora es " +
        faction.getPrestige().getColor() + e.getActualLevel().getName());
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&7La faccion &d&l" + faction.getTag() + " &7ha subido de nivel, ahora es " +
                faction.getPrestige().getColor() + e.getActualLevel().getName()));
    }


    @EventHandler
    public void onFactionsLevelDown(FactionLevelDownEvent e){
        Faction faction = e.getFaction();

        faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> Tu faccion ha bajado de nivel, ahora es " +
                faction.getPrestige().getColor() + e.getActualLevel().getName());
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&7La faccion &d&l" + faction.getTag() + " &7ha bajado de nivel, ahora es " +
                faction.getPrestige().getColor() + e.getActualLevel().getName()));
    }




}
