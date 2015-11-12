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
							Bukkit.broadcastMessage( prefix + " This Server is Being Recorded at \u00A7b" + serverYT + " !");
						} else {
							sender.sendMessage("\u00A7cMissing Permission Node: '\u00A7eytp.r.server\u00A7c'");
						}
					} else {
						Bukkit.broadcastMessage( prefix + " " + sender.getName() + " is Recording This Server at " + args[0] + " !");
					}
				} else {
					sender.sendMessage(prefix + " \u00A76Our Server's YouTube Channel is: \u00A7b" + serverYT);
				}
			} else {
				sender.sendMessage(prefix + " \u00A76Our Server's YouTube Channel is: \u00A7b" + serverYT);
			}
		} else {
			sender.sendMessage(prefix + " \u00A76Our Server's YouTube Channel is: \u00A7b" + serverYT);
		}
		return true;
	}

}
