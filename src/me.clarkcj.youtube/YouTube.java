package me.Clarkcj.youtube;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Youtube extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
    public static Youtube plugin;
    
    @Override
    public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
    
    }
    
    @Override
    public void onEnable(){
    	this.saveDefaultConfig();
    	PluginDescriptionFile pdfFile = this.getDescription();
    	this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (cmd.getName().equalsIgnoreCase("YouTube")){
			if (args.length >= 2) {
				if ( sender instanceof Player) {
					Player p = ((Player)sender);
					if ( p.hasPermission("youtube.record") || p.isOp() ) {
						if ( args[0].equalsIgnoreCase("record") ) {
							if ( args[1].equalsIgnoreCase("-server")) {
								Bukkit.broadcastMessage(getConfig().getString("prefix").replace('&', '§') + " Our Server is recording at §3 " + getConfig().getString("YTChannel") + "!");
							} else {
								Bukkit.broadcastMessage(getConfig().getString("prefix").replace('&', '§') + " " + sender.getName() + " is recording our server at " + args[1] + "!");
							}
						}
					}
				}
			} else {
				sender.sendMessage(ChatColor.GOLD + "Our Server's YouTube Channel is: "  + ChatColor.DARK_AQUA + getConfig().getString("YTChannel"));
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("Twitch")){
			if (args.length >= 2) {
				if ( sender instanceof Player) {
					Player p = ((Player)sender);
					if ( p.hasPermission("twith.stream") || p.isOp() ) {
						if ( args[0].equalsIgnoreCase("stream") ) {
							if ( args[1].equalsIgnoreCase("-server")) {
								Bukkit.broadcastMessage(getConfig().getString("prefix").replace('&', '§') + "Our Server is streaming at: §3 " + getConfig().getString("Twitch") + "!");
							} else {
								Bukkit.broadcastMessage(getConfig().getString("prefix").replace('&', '§') + " " + sender.getName() + " is streaming our server at " + args[1] + "!");
							}
						}
					}
				}
			} else {
				sender.sendMessage(ChatColor.GOLD + "The Server's Twitch Channel is: " + ChatColor.DARK_AQUA + getConfig().getString("Twitch"));
			}
			return true;
		} else {
			return false;
		}
	}
}
