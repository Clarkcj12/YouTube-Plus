package me.Clarkcj.youtube;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TwitchExe implements CommandExecutor {
	
	Youtube main;
	String prefix;
	String serverStream;
	
	public TwitchExe(Youtube main, String prefix, String channel) {
		this.main = main;
		this.prefix = prefix;
		this.serverStream = channel;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = ((Player) sender);
			if (args.length > 0) {
				if (p.hasPermission("ytp.s") || p.isOp()) {
					if ( args[0].equalsIgnoreCase("-server") ) {
						if (p.hasPermission("ytp.s.server") || p.isOp()) {
							Bukkit.broadcastMessage( prefix + " This Server is Being Live Streamed at " + serverStream + " !");
						} else {
							sender.sendMessage("§cMissing Permission Node: '§eytp.s.server§c'");
						}
					} else {
						Bukkit.broadcastMessage( prefix + " " + sender.getName() + " is Streaming This Server at " + args[0] + " !");
					}
				} else {
					sender.sendMessage(prefix + " §6Our Server's Twitch Channel is: §3" + serverStream);
				}
			} else {
				sender.sendMessage(prefix + " §6Our Server's Twitch Channel is: §3" + serverStream);
			}
		} else {
			sender.sendMessage(prefix + " §6Our Server's Twitch Channel is: §3" + serverStream);
		}
		return true;
	}

}
