package me.Clarkcj.youtube;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

public class Youtube extends JavaPlugin {
	public static Youtube plugin;

	@Override
	public void onEnable() {

		System.out.println("|======================================|");
		System.out.println("| Plugin: YouTubePlus                  |");
		System.out.println("| Created By: Clarkcj                  |");
		System.out.println("| Maintained By: willies952002         |");
                System.out.println("| Version: 1.7.9                       |");
		System.out.println("| \033[1;31mWARNING: THIS PLUGIN WILL BE UPDATED \033[0m|");
		System.out.println("| \033[1;31m  A LOT IN THE UPCOMING WEEKS        \033[0m|");
		System.out.println("|======================================|");

		this.saveDefaultConfig();
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			getLogger().severe("Failed to Submit Metrics Data to MCStats");
		}
		getCommand("youtube").setExecutor(new YouTubeExe(this, getConfig().getString("prefix").replace('&', '§'), getConfig().getString("YTChannel")));
		getCommand("twitch").setExecutor(new TwitchExe(this,getConfig().getString("prefix").replace('&', '§'), getConfig().getString("Twitch")));
	}

}
