package us.mcthemeparks.socialplus;

import co.aikar.commands.BukkitCommandManager;
import com.domnian.mcutils.TaskChain;
import com.domnian.mcutils.Util;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

public class SocialPlus extends JavaPlugin {

    // Use AtomicReference for thread-safe singleton (modern Java approach)
    private static final AtomicReference<SocialPlus> instance = new AtomicReference<>();

    public void onEnable() {
        if (!instance.compareAndSet(null, this)) {
            // Fail-safe check to ensure only one instance is active
            throw new IllegalStateException("SocialPlus instance already initialized!");
        }

        // Call helper methods confidently without null-checking the instance
        logStartupMessage();
        initializeConfig();
        configureMetrics();
        registerCommands();
        initializeTaskChain();
    }

    @Override
    public void onDisable() {
        instance.set(null);
    }

    /**
     * Logs the startup banner and information to console.
     */
    private void logStartupMessage() {
        String banner = """
                |======================================|
                | Plugin: SocialPlus                  |
                | Created By: Clarkcj                  |
                | Contributions By: willies952002      |
                | Version: 2.14-dev                    |
                |======================================|
                """;
        getLogger().info(banner);
    }

    /**
     * Initializes the plugin configuration.
     */
    private void initializeConfig() {
        new SocialConfig();
    }
    /**
     * Start Metrics using bStats.
     */
    private void configureMetrics() {
        if (SocialConfig.enableMetrics) {
            try {
                getLogger().info("Starting Metrics...");
                int pluginId = 626; // bStats plugin ID
                new Metrics(this, pluginId);
                getLogger().info("Metrics started successfully.");
            } catch (Exception e) {
                getLogger().log(Level.SEVERE, "Failed to start metrics", e);
            }
        }
    }

    /**
     * Register commands with ACF library (or forked version) and PaperCommandManager.
     */
    private void registerCommands() {
        try {
            BukkitCommandManager manager = new BukkitCommandManager(this);
            manager.registerCommand(new SocialPlusCommands()); // Register commands
            getLogger().info("Commands have been successfully registered.");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Failed to register commands", e);
        }
    }

    /**
     * Initialize TaskChain for asynchronous task scheduling.
     */
    private void initializeTaskChain() {
        try {
            TaskChain.initialize(this); // Initialize TaskChain system
            getLogger().info("TaskChain initialized successfully.");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Failed to initialize TaskChain", e);
        }
    }

    /**
     * Get the singleton instance of SocialPlus (thread-safe with AtomicReference).
     */
    public static SocialPlus getInstance() {
        return instance.get(); // Atomic safe get
    }

    /**
     * Static utility method to retrieve the plugin's prefix.
     *
     * @return Colorized prefix or fallback string if null
     */
    public static String getPrefix() {
        String prefix = instance.get().getConfig().getString("prefix", "[DefaultPrefix]");
        return Util.color(prefix);
    }
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