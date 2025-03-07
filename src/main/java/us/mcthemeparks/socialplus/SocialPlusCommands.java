package us.mcthemeparks.socialplus;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.domnian.mcutils.Util;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;

public class SocialPlusCommands extends BaseCommand {

    @CommandAlias("youtube|yt")
    @Description("Get the link to the server's YouTube channel.")
    public void onYoutube(@Single Player player) {
        var youtubeLink = SocialConfig.youTube;
        var prefix = SocialConfig.prefix;

        player.sendMessage(Component.text()
                .append(serializeColor(prefix))
                .append(Component.text(" Our YouTube channel: ", WHITE))
                .append(Component.text(youtubeLink, AQUA))
        );
    }

    @Subcommand("server")
    @CommandPermission("ytp.server")
    public void onServer(Player player) {
        Util.sendMsg(player, SocialConfig.prefix + "This server is being recorded at \u00A7b" + SocialConfig.youTube + " !");
    }

    @CommandAlias("ytpheko|ytp|youtubeplus")
    public void onHelp(Player player) {
        Util.sendMsg(player, "&6YouTube Plus v&e" + SocialPlus.getInstance().getDescription().getVersion() + " &6Commands:");
        Util.sendMsg(player, "&b-» &a/discord [invite] &6- &8 Display Discord Invite Link");
        Util.sendMsg(player, "&b-» &a/donate &6- &8Display Link to Donation Store");
        Util.sendMsg(player, "&b-» &a/facebook &6- &8Display Link to Facebook Page");
        Util.sendMsg(player, "&b-» &a/irc &6- &8Display IRC Server & Channel Information");
        Util.sendMsg(player, "&b-» &a/mumble [get] &6- &8Display Mumble Server Information");
        Util.sendMsg(player, "&b-» &a/skype &6- &8Display Skype Group Invite Link");
        Util.sendMsg(player, "&b-» &a/teamspeak [get] &6- &8Display TeamSpeak Server Information");
        Util.sendMsg(player, "&b-» &a/ts3 [get] &6- &8Alias of /teamspeak");
        Util.sendMsg(player, "&b-» &a/website &6- &8Display Server Website");
    }

    /**
     * Convert prefixed legacy text to an Adventure Component.
     */
    private Component serializeColor(String message) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(message);
    }
}

}