package me.Clarkcj.youtube;

import java.util.logging.Logger;

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
    	PluginDescriptionFile pdfFile = this.getDescription();
    	this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
    	getConfig().options().copyDefaults(true);
    	saveConfig();
  
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("YouTube")){
			player.sendMessage(ChatColor.GOLD + "Our Server's YouTube Channel is: "  + ChatColor.DARK_AQUA + getConfig().getString("YTChannel"));
		}else if (cmd.getName().equalsIgnoreCase("yt")){
			player.sendMessage(ChatColor.GOLD + " Our Server's YouTube Channel is: " + ChatColor.DARK_AQUA + getConfig().getString("YTChannel"));
		}else if (cmd.getName().equalsIgnoreCase("Twitch")){			
			player.sendMessage(ChatColor.GOLD + "The Server's Twitch Channel is: " + ChatColor.DARK_AQUA + getConfig().getString("Twitch"));
		}
			
		return false;
	}
}
