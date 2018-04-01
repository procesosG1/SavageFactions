package com.massivecraft.factions.zcore.FLevelPrestiges;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public enum Level {

    ALPHA(1,"Alpha",0),
    BRAVO(2,"Bravo",Conf.costLevelBravo),
    CHARLIE(3,"Charlie",Conf.costLevelCharlie),
    DELTA(4,"Delta",Conf.costLevelDelta),
    ECHO(5,"Echo",Conf.costLevelEcho),
    FOXTROT(6,"Foxtrot",Conf.costLevelFoxtrot),
    GOLF(7,"Golf",Conf.costLevelGolf),
    HOTEL(8,"Hotel",Conf.costLevelHotel),
    INDIA(9,"India",Conf.costLevelIndia),
    JULIET(10,"Juliet",Conf.costLevelJuliet);

    private int level ;
    private String name;
    private int points;


    Level(int level, String name, int points) {
        this.level = level;
        this.name = name;
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public static Level getLevelByNumber(int number) {
        for(Level level : Level.values()){
            if(level.getLevel() == number)
                return level;
        }
        return null;
    }

    public int getPoints() {
        return points;
    }

    public ItemStack buildItem(FPlayer fPlayer, Level level, Prestige prestige){
        Material material = null;
        ItemStack item;
        Faction faction = fPlayer.getFaction();
        int points = level.getPoints();
        switch (prestige){
            case INITIAL:
                material = Material.COAL;
                break;
            case NOOB:
                material = Material.IRON_INGOT;
                break;

            case STARTER:
                material = Material.GOLD_INGOT;
                break;

            case KILLER:
                material = Material.DIAMOND;
                break;

            case WARRIOR:
                material = Material.EMERALD;
                break;

            case MASTER:
                material = Material.IRON_AXE;
                break;

            case BEAST:
                material = Material.GOLD_AXE;
                break;

            case IMPERIO:
                material = Material.DIAMOND_AXE;
                break;

        }
        if(level.getLevel() < faction.getLevel().getLevel())
            material = Material.EMERALD;

        item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&e&m---------------&6<>&e&m---------------"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bTu prestigio: &7&l" + fPlayer.getFaction().getPrestige().getName()));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));

        lore.add(ChatColor.translateAlternateColorCodes('&', "&e&m----------------------------------"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bTu nivel: &7&l" + fPlayer.getFaction().getLevel().getName()));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&e&m----------------------------------"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dPuntos necesarios: &7" + points));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dTus puntos: &7" + faction.getLevelPoints()));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&e&m----------------------------------"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dVentajas:"));
        lore.add(ChatColor.translateAlternateColorCodes('&', " "));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        meta.setLore(lore);
        meta.setDisplayName(prestige.getColor() + level.getName());
        item.setItemMeta(meta);
        return item;
    }

}
