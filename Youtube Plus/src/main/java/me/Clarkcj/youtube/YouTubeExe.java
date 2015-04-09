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
			if (args.length >= 1) {
				if (p.hasPermission("ytp.r") || p.isOp()) {
					if ( args[0].equalsIgnoreCase("-server") ) {
						if (p.hasPermission("ytp.r.server") || p.isOp()) {
							Bukkit.broadcastMessage( prefix + " This Server is Being Recorded at " + serverYT + " !");
						} else {
							sender.sendMessage("§cMissing Permission Node: '§eytp.r.server§c'");
						}
					} else {
						Bukkit.broadcastMessage( prefix + " " + sender.getName() + " is Recording This Server at " + args[0] + " !");
					}
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
