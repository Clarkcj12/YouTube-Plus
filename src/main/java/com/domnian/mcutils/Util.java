package com.domnian.mcutils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void sendMsg(Player player, String msg) {
        player.sendMessage(color(msg));
    }

    public static void sendFMsg(Player player, String format, Object... params) {
        Util.sendMsg(player, String.format(format, params));
    }

    public static void printException(String error_with_contacting_twitch_api, Exception e) {
    }

    public static void log(String s) {
    }
}