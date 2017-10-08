package us.mcthemeparks.youtube;

import co.aikar.commands.ACF;
import com.domnian.mcutils.TaskChain;
import com.domnian.mcutils.Util;
import org.bukkit.plugin.java.JavaPlugin;
import us.mcthemeparks.youtube.commands.*;

import java.io.IOException;

@SuppressWarnings({"unused", "deprecated"})
public class YouTubePlus extends JavaPlugin {

    public static YouTubePlus instance;

    @Override
    public void onEnable() {
        instance = this;
        enableMessage();
        if (YouTubePlusConfig.enableMetrics) startMetrics();*/
        new YouTubePlusConfig();
        ACF.createManager(this).registerCommand(new YouTubePlusCommands());
        TaskChain.initialize(this);
    }

    private void enableMessage() {
        getLogger().info("|======================================|");
        getLogger().info("| Plugin: YouTubePlus                  |");
        getLogger().info("| Created By: Clarkcj                  |");
        getLogger().info("| Contributions By: willies952002      |");
        getLogger().info("| Version: 2.12-dev                    |");
        getLogger().info("|======================================|");
    }

    private void registerCommands() {
       getLogger().info("Registering Commands");
        getCommand("youtube").setExecutor(new YouTubeExe());
        getCommand("twitch").setExecutor(new TwitchExe());
        getCommand("mixer").setExecutor(new MixerExe());
        getCommand("ustream").setExecutor(new UstreamExe());
        getCommand("LiveCoding").setExecutor(new LivecodingExe());
        getCommand("smashcast").setExecutor(new SmashCastExe());
        getCommand("ytpversion").setExecutor(new VersionExe());
    }

    private void registerEvents() {

    }

    private void startMetrics() {
        try {
            getLogger().info("Starting Metrics");
            new org.mcstats.Metrics(this).start();
            new org.bstats.Metrics(this);
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