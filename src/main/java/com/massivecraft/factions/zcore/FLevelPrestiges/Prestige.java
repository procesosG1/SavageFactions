package com.massivecraft.factions.zcore.FLevelPrestiges;

import org.bukkit.ChatColor;

public enum Prestige {

    INITIAL("Initial", ChatColor.WHITE,1),
    NOOB("Noob", ChatColor.YELLOW,2),
    STARTER("Starter", ChatColor.GREEN,3),
    KILLER("Killer", ChatColor.RED,4),
    WARRIOR("Warrior", ChatColor.DARK_RED,5),
    MASTER("Master", ChatColor.BLUE,6),
    BEAST("Beast", ChatColor.LIGHT_PURPLE,7),
    IMPERIO("Imperio", ChatColor.AQUA,8);

    private String name;
    private ChatColor color;
    private int number;

    Prestige(String name, ChatColor color, int number) {
        this.name = name;
        this.color = color;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public static Prestige getPrestigeByNumber(int number) {
        for(Prestige prestige : Prestige.values()){
            if(prestige.getNumber() == number)
                return prestige;
        }
        return null;
    }
}
