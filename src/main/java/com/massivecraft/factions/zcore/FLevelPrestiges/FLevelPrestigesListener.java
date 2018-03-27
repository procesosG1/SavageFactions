package com.massivecraft.factions.zcore.FLevelPrestiges;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FLevelsEvents.FactionGainedPointsEvent;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FLevelPrestigesListener implements Listener {



    @EventHandler
    public void onFactionPlayerJoin(FPlayerJoinEvent e){
        Faction faction = e.getFaction();
        faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> El jugador &a&l" + e.getfPlayer().getName() + " &8se ha unido a tu faccion, ganais &d&l5 &ePuntos de nivel!");
        faction.addLevelPoints(5);
        FactionGainedPointsEvent event = new FactionGainedPointsEvent(faction,5);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }


    @EventHandler
    public void onFactiongainedPointsEvent(FactionGainedPointsEvent e){
        Faction faction = e.getFaction();
        
    }


}
