package com.massivecraft.factions.cmd;

import com.massivecraft.factions.zcore.FLevelPrestiges.GUI.FLevelGui;
import com.massivecraft.factions.zcore.FLevelPrestiges.Level;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.ChatColor;

public class CmdPrestige extends FCommand{


    public CmdPrestige() {
        super();
        this.aliases.add("levels");
        this.aliases.add("level");
        this.aliases.add("lvl");
        this.aliases.add("prestige");
        this.aliases.add("prestiges");
        this.aliases.add("l");
        this.disableOnLock = true;
        this.senderMustBePlayer = true;


    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_PRESTIGES_DESCRIPTION;
    }

    @Override
    public void perform() {

        if(!fme.hasFaction()){
            fme.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTienes que tener faccion para hacer eso!"));
            return;

        }

        FLevelGui gui = new FLevelGui(fme);
        gui.build();
        me.openInventory(gui.getInventory());

    }
}
