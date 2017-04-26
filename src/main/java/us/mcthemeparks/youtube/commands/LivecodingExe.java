package us.mcthemeparks.youtube.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.mcthemeparks.youtube.YouTubePlus;

public class LivecodingExe implements CommandExecutor {

    YouTubePlus main;
    String prefix;
    String serverStream;

    public LivecodingExe() {
        this.main = YouTubePlus.getInstance();
        this.prefix = YouTubePlus.getPrefix();
        this.serverStream = main.getConfig().getString("LiveCoding");
    }

    @Override
    public boolean onCommand(CommandSender s, Command c, String commandLabel, String[] a) {
        if (s instanceof Player) {
            Player p = ((Player) s);
            if (a.length > 0) {
                if (p.hasPermission("ytp.s") || p.isOp()) {
                    if (a[0].equalsIgnoreCase("-server")) {
                        if (p.hasPermission("ytp.s.server") || p.isOp()) {
                            Bukkit.broadcastMessage(prefix + " This Server is Being Live Streamed at \u00A7b" + serverStream + " !");
                        } else {
                            s.sendMessage("\u00A7cMissing Permission Node: '\u00A7eytp.s.server\u00A7c'");
                        }
                    } else {
                        Bukkit.broadcastMessage(prefix + " " + s.getName() + " is Streaming This Server at \u00A7b" + a[0] + " !");
                    }
                } else {
                    s.sendMessage(prefix + " \u00A76Our Server's LiveCoding Channel is: \u00A7b" + serverStream);
                }
            } else {
                s.sendMessage(prefix + " \u00A76Our Server's LiveCoding Channel is: \u00A7b" + serverStream);
            }
        } else {
            s.sendMessage(prefix + " \u00A76Our Server's LiveCoding Channel is: \u00A7b" + serverStream);
        }
        return true;
    }
}