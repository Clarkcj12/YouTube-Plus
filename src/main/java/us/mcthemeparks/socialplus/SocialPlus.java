package us.mcthemeparks.socialplus;

import co.aikar.commands.BukkitCommandManager;
import com.domnian.mcutils.TaskChain;
import com.domnian.mcutils.Util;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

@SuppressWarnings({"unused", "deprecated"})
public class SocialPlus extends JavaPlugin {

    public static SocialPlus instance;

    @Override
    public void onEnable() {
        instance = this;
        enableMessage();
        if (SocialConfig.enableMetrics) startMetrics();
        new SocialConfig();
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new SocialPlusCommands());
        TaskChain.initialize(this);
    }

    private void enableMessage() {
        getLogger().info("|======================================|");
        getLogger().info("| Plugin: SocialPlus                  |");
        getLogger().info("| Created By: Clarkcj                  |");
        getLogger().info("| Contributions By: willies952002      |");
        getLogger().info("| Version: 2.14-dev                    |");
        getLogger().info("|======================================|");
    }

//    private void registerCommands() {
//       getLogger().info("Registering Commands");
//        getCommand("youtube").setExecutor(new YouTubeExe());
//        getCommand("twitch").setExecutor(new TwitchExe());
//        getCommand("mixer").setExecutor(new MixerExe());
//        getCommand("ustream").setExecutor(new UstreamExe());
//        getCommand("LiveCoding").setExecutor(new LivecodingExe());
//        getCommand("smashcast").setExecutor(new SmashCastExe());
//        getCommand("ytpversion").setExecutor(new VersionExe());
//    }

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

    public static SocialPlus getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return Util.color(instance.getConfig().getString("prefix"));
    }
}