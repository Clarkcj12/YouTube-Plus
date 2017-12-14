package us.mcthemeparks.socialplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.mcthemeparks.socialplus.SocialPlus;

/**
 * ==================================================================
 * Copyright McThemeParks Dev. (c) 2015. All Rights Reserved
 * Any Code contained within this document, and any associated APIs
 * with similar branding are the sole property of McThemeParks.
 * Distribution, reproduction, taking snippets, or claiming any
 * contents as your own will break the terms of the license, and
 * void any agreements with you, the third party. Thanks
 * ==================================================================
 */
public class VersionExe implements CommandExecutor {
    SocialPlus main;
    String prefix;

    public VersionExe() {

        this.main = SocialPlus.getInstance();
        this.prefix = SocialPlus.getPrefix();
    }

    @Override
    public boolean onCommand(CommandSender s, Command c, String commandLabel, String[] a){
        if (s instanceof Player) {
            s.sendMessage(this.prefix + ChatColor.GREEN + " Version " + ChatColor.GOLD + ": " + ChatColor.RED + "2.13");
        }
        return true;
    }
}