package us.mcthemeparks.socialplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.mcthemeparks.socialplus.SocialPlus;

public class YouTubeExe implements CommandExecutor {

    SocialPlus main;
    String prefix;
    String serverYT;

    public YouTubeExe() {
        this.main = SocialPlus.getInstance();
        this.prefix = SocialPlus.getPrefix();
        this.serverYT = main.getConfig().getString("YTChannel");
    }

    @Override
    public boolean onCommand(CommandSender s, Command c, String commandLabel, String[] a) {
        if (s instanceof Player) {
            Player p = ((Player) s);
            if (a.length >= 1) {
                if (p.hasPermission("ytp.r") || p.isOp()) {
                    if (a[0].equalsIgnoreCase("-server")) {
                        if (p.hasPermission("ytp.r.server") || p.isOp()) {
                            Bukkit.broadcastMessage(prefix + " This Server is Being Recorded at \u00A7b" + serverYT + " !");
                        } else {
                            s.sendMessage("\u00A7cMissing Permission Node: '\u00A7eytp.r.server\u00A7c'");
                        }
                    } else {
                        Bukkit.broadcastMessage(prefix + " " + s.getName() + " is Recording This Server at " + a[0] + " !");
                    }
                } else {
                    s.sendMessage(prefix + " \u00A76Our Server's YouTube Channel is: \u00A7b" + serverYT);
                }
            } else {
                s.sendMessage(prefix + " \u00A76Our Server's YouTube Channel is: \u00A7b" + serverYT);
            }
        } else {
            s.sendMessage(prefix + " \u00A76Our Server's YouTube Channel is: \u00A7b" + serverYT);
        }
        return true;
    }

}
