package com.massivecraft.factions.zcore.FLevelPrestiges.GUI;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.util.FactionGUI;
import com.massivecraft.factions.zcore.FLevelPrestiges.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FLevelGui implements InventoryHolder, FactionGUI{

    private Inventory inventory;
    private HashMap<Integer, Level> levels = new HashMap<>();
    private int guiSize;
    private FPlayer fme;

    public FLevelGui(FPlayer fme) {
        this.fme = fme;
        this.guiSize = 27;
    }

    @Override
    public void onClick(int slot, ClickType action) {

    }

    @Override
    public void build() {
        int i = 9;
        String guiTitle = ChatColor.translateAlternateColorCodes('&', "&d&lPrestigios");
        inventory = Bukkit.createInventory(this, guiSize, guiTitle);
        for(Level level : Level.values()){

            if(!level.equals(Level.ALPHA)){
                levels.put(i,level);
                i++;
            }

        }
        buildItems();

    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }



    private void buildItems(){

        ItemStack decoration = new ItemStack(Material.STAINED_GLASS);
        ItemMeta dec = decoration.getItemMeta();
        dec.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        dec.setDisplayName("");
        decoration.setItemMeta(dec);

        ItemStack info = new ItemStack(Material.ANVIL);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&e&m---------------&6< &d&lPRESTIGIOS &6>&E&m---------------"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Gana puntos de nivel y sube de nivel y prestigio para"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7ganar diferentes habilidades para los miembros!"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dPara poder ganar puntos de nivel y progresar"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dnecesitas tener una faccion"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&dcon un minimo de 10 personas y una base hecha!"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Ten cuidado! Al morir o perder el control de fortalezas,"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7perderás puntos y podrás bajar de nivel y prestigio!"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));

        ItemMeta meta = info.getItemMeta();
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lFaction Prestiges"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        info.setItemMeta(meta);

        for(int i = 0; i <= 3; i++)
            inventory.setItem(i,decoration);
        inventory.setItem(4,info);
        for(int i = 5; i <= 8; i++)
            inventory.setItem(i,decoration);

        for(Map.Entry<Integer,Level> entry : levels.entrySet()){

            ItemStack item = new ItemStack(entry.getValue().buildItem(fme,entry.getValue(),fme.getFaction().getPrestige()));
            addItemFeatures(item,entry.getValue());
            inventory.setItem(entry.getKey(),item);

        }
        for (int i = 18; i<= 26; i++){
            inventory.setItem(i,decoration);
        }

    }

    private void addItemFeatures(ItemStack item, Level level) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        switch (level){
            case BRAVO:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresBravo));
                break;
            case CHARLIE:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresCharlie));
                break;
            case DELTA:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresDelta));
                break;
            case ECHO:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresEcho));
                break;
            case FOXTROT:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresFoxtrot));
                break;
            case GOLF:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresGolf));
                break;
            case HOTEL:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresHotel));
                break;
            case INDIA:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresIndia));
                break;
            case JULIET:
                lore.add(ChatColor.translateAlternateColorCodes('&',Conf.featuresJuliet));
                break;
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}
