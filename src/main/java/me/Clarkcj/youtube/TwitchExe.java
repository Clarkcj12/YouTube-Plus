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
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (sender instanceof Player) {
			Player p = ((Player) sender);
			if (args.length > 0) {
				if (p.hasPermission("ytp.s") || p.isOp()) {
					if ( args[0].equalsIgnoreCase("-server") ) {
						if (p.hasPermission("ytp.s.server") || p.isOp()) {
							Bukkit.broadcastMessage( prefix + " This Server is Being Live Streamed at \u00A7b" + serverStream + " !");
						} else {
							sender.sendMessage("�cMissing Permission Node: '\u00A7eytp.s.server\u00A7c'");
						}
					} else {
						Bukkit.broadcastMessage( prefix + " " + sender.getName() + " is Streaming This Server at \u00A7b" + args[0] + " !");
					}
				} else {
					sender.sendMessage(prefix + " \u00A76Our Server's Twitch Channel is: \u00A7b" + serverStream);
				}
			} else {
				sender.sendMessage(prefix + " \u00A76Our Server's Twitch Channel is: \u00A7b" + serverStream);
			}
		} else {
			sender.sendMessage(prefix + " \u00A76Our Server's Twitch Channel is: \u00A7b" + serverStream);
		}
		return true;
	}

}
