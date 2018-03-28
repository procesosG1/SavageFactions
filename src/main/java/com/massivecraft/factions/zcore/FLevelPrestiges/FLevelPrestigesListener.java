package com.massivecraft.factions.zcore.FLevelPrestiges;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.event.FPlayerLeaveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FLevelPrestigesListener implements Listener {

    @EventHandler
    public void onFactionPlayerJoin(FPlayerJoinEvent e){
        Faction faction = e.getFaction();
        faction.broadCastMessage("&a&l" + faction.getTag() + "&7>&8> El jugador &a&l" + e.getfPlayer().getName() + " &8se ha unido a tu faccion, ganais &d&l5 &ePuntos de nivel!");
        faction.addLevelPoints(5);
    }

    @EventHandler
    public void onFactionPlayerLeave(FPlayerLeaveEvent e){
        Faction faction = e.getFaction();
        faction.broadCastMessage("&c&l" + faction.getTag() + "&7>&8> El jugador &c&l" + e.getfPlayer().getName() + " &8se ha salido de tu faccion, perdeis &d&l5 &ePuntos de nivel!");
        faction.takeLevelPoints(5);
    }


}
