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
		System.out.println("| Contributions By: willies952002      |");
		System.out.println("| Version: 2.0-dev                     |");
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
