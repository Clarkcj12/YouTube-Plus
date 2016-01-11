package me.Clarkcj.youtube;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class YouTubePlus extends JavaPlugin {

	private static YouTubePlus instance;

	@Override
	public void onEnable() {
        enableMessage();
		saveDefaultConfig();
        registerCommands();
        registerEvents();
		startMetrics();
    }

    private void enableMessage() {
        getLogger().info("|======================================|");
        getLogger().info("| Plugin: YouTubePlus                  |");
        getLogger().info("| Created By: Clarkcj                  |");
        getLogger().info("| Contributions By: willies952002      |");
        getLogger().info("| Version: 2.0-dev                     |");
        getLogger().info("|======================================|");
    }

    private void registerCommands() {
        getCommand("youtube").setExecutor(new YouTubeExe());
    }

    private void registerEvents() {

    }

    private void startMetrics() {
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            getLogger().severe("Failed to Submit Metrics Data to MCStats");
        }
    }
    
    public static YouTubePlus getInstance() {
        return instance;
    }

}
