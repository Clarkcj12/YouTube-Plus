package us.mcthemeparks.youtube;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import com.domnian.mcutils.Util;
import org.bukkit.entity.Player;

/**
 * Created by Corey on 4/26/2017.
 */
public class YouTubePlusCommands extends BaseCommand {

    @CommandAlias("youtube")
    public void onYoutube(Player player) {
        Util.sendMsg(player, "&r");
        Util.sendMsg(player, "");
    }

    @CommandAlias("ytpheko|ytp|youtubeplus")
       public void onHelp(Player player) {
        Util.sendMsg(player, "&6Voice Plus v&e" + YouTubePlus.instance.getDescription().getVersion() + " &6Commands:");
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