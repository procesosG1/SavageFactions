package com.massivecraft.factions.event.FLevelsEvents;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.zcore.FLevelPrestiges.Level;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionLevelDownEvent extends Event{
    private static final HandlerList handlers = new HandlerList();

    private Faction faction;
    private Level actualLevel;

    public FactionLevelDownEvent(Faction faction, Level level) {
        this.faction = faction;
        actualLevel = level;
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

    public Level getActualLevel() {
        return actualLevel;
    }



}
