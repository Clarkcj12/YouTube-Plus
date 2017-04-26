package us.mcthemeparks.youtube;

import com.domnian.mcutils.config.ConfigNode;
import com.domnian.mcutils.config.MagicConfig;
/**
 * Created by Corey on 4/26/2017.
 */
public class YouTubePlusConfig extends MagicConfig {
    public YouTubePlusConfig() {
        super(YouTubePlus.instance, "config", YouTubePlusConfig.class, 2);

        @ConfigNode("metrics")
        public static boolean enableMetrics = true;

        @ConfigNode("Youtube")
        public static String youTube = "<YouTube Link>";

        @ConfigNode("Donate")
        public static String donate = "<Donation Store>";

        @ConfigNode("Fb")
        public static String facebook = "<Facebook Page>";

        @ConfigNode("IRCServer")
        public static String ircServer = "<IRC Server Address & Port>";

        @ConfigNode("IRCChan")
        public static String ircChannel = "<IRC Channel>";

        @ConfigNode("MServer")
        public static String mumbleServer = "<Mumble Server Address>";

        @ConfigNode("MPort")
        public static int mumblePort = 64738;

        @ConfigNode("Skype")
        public static String skype = "<Skype Group Invite Link>";

        @ConfigNode("TServer")
        public static String ts3Server = "<Team Speak Server Address>";

        @ConfigNode("TPort")
        public static int ts3Port = 9987;

        @ConfigNode("Website")
        public static String website = "<Website Link>";

    }
}