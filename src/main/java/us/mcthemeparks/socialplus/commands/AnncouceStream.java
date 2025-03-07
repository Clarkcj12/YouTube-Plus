package us.mcthemeparks.socialplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.mcthemeparks.socialplus.SocialConfig;

public class AnncouceStream implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length > 0 && args[0].equalsIgnoreCase("stream")) {
            if (player.hasPermission("ytp.s")) {
                String prefix = SocialConfig.prefix;
                String channel = SocialConfig.youTube;
                Bukkit.broadcastMessage(prefix + " " + player.getName() + " is now streaming on " + channel);
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
        } else if (args.length > 0 && args[0].equalsIgnoreCase("record")) {
            player.sendMessage("Recording functionality is not implemented yet.");
        } else {
            player.sendMessage("Invalid usage. Try /youtubeplus stream or /youtubeplus record.");
        }

        return true;
    }
}
