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
    public void onYoutube(Player player){
        Util.sendMsg(player, "&r");
        Util.sendMsg(player, "");
    }

    @CommandAlias("ytp|youtubeplus|yp")
    public void onHelp(Player player){
        Util.sendMsg(player, "&6YouTubePlus v&e" + YouTubePlus.instance.getDescription().getVersion() + " &6Commands:");
    }
}