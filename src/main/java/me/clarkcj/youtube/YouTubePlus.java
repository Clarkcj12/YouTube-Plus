package me.clarkcj.youtube;

import com.domnian.util.TaskChain;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YouTubePlus extends JavaPlugin {

	private static YouTubePlus instance;

    @Override
	public void onEnable() {
        enableMessage();
		saveDefaultConfig();
        registerCommands();
        registerEvents();
		startMetrics();
        TaskChain.initialize(this);
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
        getCommand("stream").setExecutor(new StreamExe());
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

    public static String getPrefix() {
        return instance.getConfig().getString("prefix");
    }

}