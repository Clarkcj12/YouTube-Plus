package me.clarkcj.youtube;

import com.domnian.util.TaskChain;
import com.domnian.util.Util;
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
        instance = this;
        enableMessage();
		saveDefaultConfig();
        registerEvents();
        registerCommands();
		startMetrics();
        TaskChain.initialize(this);
    }

    private void enableMessage() {
        getLogger().info("|======================================|");
        getLogger().info("| Plugin: YouTubePlus                  |");
        getLogger().info("| Created By: Clarkcj                  |");
        getLogger().info("| Contributions By: willies952002      |");
        getLogger().info("| Version: 2.1-dev                     |");
        getLogger().info("|======================================|");
    }

    private void registerCommands() {
        getLogger().info("Registering Commands");
        getCommand("youtube").setExecutor(new YouTubeExe());
        getCommand("stream").setExecutor(new StreamExe());
    }

    private void registerEvents() {

    }

    private void startMetrics() {
        try {
            getLogger().info("Starting Metrics");
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
        return Util.color(instance.getConfig().getString("prefix"));
    }

}