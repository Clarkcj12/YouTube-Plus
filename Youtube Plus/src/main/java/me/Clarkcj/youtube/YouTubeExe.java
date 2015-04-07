package me.Clarkcj.youtube;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class YouTubeExe implements CommandExecutor {

	Youtube main;
	String prefix;
	String serverYT;
	
	public YouTubeExe(Youtube main, String prefix, String channel) {
		this.main = main;
		this.prefix = prefix;
		this.serverYT = channel;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = ((Player) sender);
			if (args.length > 0) {
				if (p.hasPermission("ytp.r") || p.isOp()) {
					Bukkit.broadcastMessage( prefix + " " + sender.getName() + " is Recording This Server at " + args[1] + " !");
				} else {
					sender.sendMessage(prefix + " §6Our Server's YouTube Channel is: §3" + serverYT);
				}
			} else {
				sender.sendMessage(prefix + " §6Our Server's YouTube Channel is: §3" + serverYT);
			}
		} else {
			sender.sendMessage(prefix + " §6Our Server's YouTube Channel is: §3" + serverYT);
		}
		return true;
	}

}
