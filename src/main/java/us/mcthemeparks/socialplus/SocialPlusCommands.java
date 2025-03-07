package us.mcthemeparks.socialplus;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Single;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import static net.kyori.adventure.text.format.NamedTextColor.*; // Text color constants

/**
 * SocialPlusCommands: Handles YouTube Plus-related player commands.
 * Updated to remove deprecated APIs and modern standards using Paper 1.21.4 and Adventure API.
 */
@CommandAlias("social")
public class SocialPlusCommands extends BaseCommand {

    // Updated Method: Sends YouTube link with a properly formatted message
    @CommandAlias("youtube|yt")
    @Description("Get the link to the server's YouTube channel.")
    public void onYoutube(@Single Player player) {
        var youtubeLink = SocialConfig.youTube;
        var prefix = SocialConfig.prefix;

        player.sendMessage(
                Component.text()
                        .append(deserializeLegacy(prefix))
                        .append(Component.text(" Our YouTube channel: ", WHITE))
                        .append(Component.text(youtubeLink, AQUA))
                        .build()
        );
    }

    // Modernized Method: Inform player about server recording status
    @Subcommand("server")
    @CommandPermission("ytp.server")
    @Description("Provide server recording information.")
    public void onServer(@Single Player player) {
        var message = Component.text()
                .append(deserializeLegacy(SocialConfig.prefix))
                .append(Component.text(" This server is being recorded at: ", WHITE))
                .append(Component.text(SocialConfig.youTube, AQUA))
                .append(Component.text("!", WHITE))
                .build();

        player.sendMessage(message);
    }

    // Updated Help Command: Displays command usage in modernized format
    @CommandAlias("youtubeplus|ytp|ytpheko")
    @Description("Display help for all SocialPlus commands.")
    @Default
    public void onHelp(@Single Player player) {
        // Using Adventure Components to display a modern help message
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
     * Converts legacy `&` color codes to modern Adventure `Component`.
     * Paper's modern APIs encourage using `Component` instead of legacy text serialization directly.
     */
    private Component deserializeLegacy(String legacyText) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(legacyText);
    }
}