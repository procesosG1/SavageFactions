package com.massivecraft.factions.event.FLevelsEvents;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.zcore.FLevelPrestiges.Prestige;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionPrestigeUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Faction faction;
    private Prestige actualPrestige;

    public FactionPrestigeUpEvent(Faction faction, Prestige prestige) {
        this.faction = faction;
        actualPrestige = prestige;
    }


    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }


    public Faction getFaction() {
        return faction;
    }

    public Prestige getActualLevel() {
        return actualPrestige;
    }
}
