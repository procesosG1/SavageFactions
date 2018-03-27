package com.massivecraft.factions.event.FLevelsEvents;


import com.massivecraft.factions.Faction;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionGainedPointsEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Faction faction;
    private int addedPoints;
    public FactionGainedPointsEvent(Faction faction, int points) {
        this.faction = faction;
        this.addedPoints = points;
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

    public int getAddedPoints() {
        return addedPoints;
    }
}
