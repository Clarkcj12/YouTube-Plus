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
		boolean isPlayer = (sender instanceof Player);
		sender.sendMessage("isPlayer: " + isPlayer);
		if (isPlayer) {
			Player p = ((Player) sender);
			sender.sendMessage("args: " + args.length);
			for ( String arg : args ) {
				sender.sendMessage(" " + arg);
			}
			if (args.length >= 2) {
				sender.sendMessage("hasPermission: " + (p.hasPermission("ytp.r") || p.isOp()));
				if (p.hasPermission("ytp.s") || p.isOp()) {
					Bukkit.broadcastMessage( prefix + " " + sender.getName() + " is Streaming This Server at " + args[1] + " !");
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
