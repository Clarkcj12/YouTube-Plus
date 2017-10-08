package us.mcthemeparks.youtube;

import com.domnian.mcutils.config.ConfigNode;
import com.domnian.mcutils.config.MagicConfig;
/**
 * Created by Corey on 4/26/2017.
 */
public class YouTubePlusConfig extends MagicConfig {
    public YouTubePlusConfig() {
        super(YouTubePlus.instance, "config", YouTubePlusConfig.class, 2);
    }
        @ConfigNode("metrics")
        public static boolean enableMetrics = true;

        @ConfigNode("Youtube")
        public static String youTube = "<YouTube Link>";

        @ConfigNode("Mixer")
        public static String mixer = "<Mixer Link>";

        @ConfigNode("Ustream")
        public static String ustream = "<Ustream Link>";

        @ConfigNode("Twitch")
        public static String twitch = "<Twitch Link>";

        @ConfigNode("Licecoding")
        public static String liveCoding = "<LiveCoding Link>";

        @ConfigNode("SmashCast")
        public static String smashCast = "<SmashCast Link>";
}