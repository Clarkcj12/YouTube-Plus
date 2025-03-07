package us.mcthemeparks.socialplus;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import com.domnian.mcutils.Util;
import org.bukkit.entity.Player;

/**
 * Created by Corey on 4/26/2017.
 */
public class SocialPlusCommands extends BaseCommand {

    @CommandAlias("youtube|yt")
    public void onYoutube(Player player) {
        Util.sendMsg(player, "&r");
        Util.sendMsg(player, "");
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
}