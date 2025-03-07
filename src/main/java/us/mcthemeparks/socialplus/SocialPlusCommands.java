package us.mcthemeparks.socialplus;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.domnian.mcutils.Util;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;

import static net.kyori.adventure.text.format.NamedTextColor.AQUA;
import static net.kyori.adventure.text.format.NamedTextColor.WHITE;

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
    @Description("Provide server recording information.")
    public void onServer(@Single Player player) {
        var message = Component.text()
                .append(serializeColor(SocialConfig.prefix))
                .append(Component.text(" This server is being recorded at: ", WHITE))
                .append(Component.text(SocialConfig.youTube, AQUA))
                .append(Component.text("!", WHITE));

        player.sendMessage(message);
    }

    @CommandAlias("youtubeplus|ytp|ytphelp")
    @Description("Display help for all SocialPlus commands.")
    @Default
    public void onHelp(@Single Player player) {
        var helpMessages = """
                &6YouTube Plus v&e%s Commands:
                &b-» &a/discord [invite] &6- &8Display Discord Invite Link
                &b-» &a/donate &6- &8Display Link to Donation Store
                &b-» &a/facebook &6- &8Display Facebook Page Link
                &b-» &a/irc &6- &8Display IRC Server/Channel Info
                &b-» &a/mumble [get] &6- &8Display Mumble Server Info
                &b-» &a/skype &6- &8Display Skype Group Invite Link
                &b-» &a/teamspeak [get] &6- &8TeamSpeak Server Info
                &b-» &a/ts3 [get] &6- &8Alias for /teamspeak
                &b-» &a/website &6- &8Display Server Website
                """.formatted(SocialPlus.getInstance().getDescription().getVersion());

        var message = LegacyComponentSerializer.legacyAmpersand().deserialize(helpMessages);
        player.sendMessage(message);
    }

    /**
     * Convert prefixed legacy text to an Adventure Component.
     */
    private Component serializeColor(String message) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(message);
    }
}