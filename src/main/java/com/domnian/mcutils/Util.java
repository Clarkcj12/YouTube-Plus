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
}