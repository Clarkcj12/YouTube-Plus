package us.mcthemeparks.socialplus;

import com.domnian.mcutils.config.ConfigNode;
import com.domnian.mcutils.config.MagicConfig;

/**
 * Created by Corey on 4/26/2017.
 */
public class SocialConfig extends MagicConfig {
    public SocialConfig() {
        super(SocialPlus.instance, "config", SocialConfig.class, 2);
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

        @ConfigNode("Livecoding")
        public static String liveCoding = "<LiveCoding Link>";

        @ConfigNode("SmashCast")
        public static String smashCast = "<SmashCast Link>";

        @ConfigNode("prefix")
        public static String prefix = "&7[&c&lYou&f&lTuber&7]";
}