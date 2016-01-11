/*
 * ==================================================================
 * Copyright Domnian Dev. (c) 2015. All Rights Reserved
 * Any Code contained within this document, and any associated APIs
 * with similar branding are the sole property of Domnian Dev..
 * Distribution, reproduction, taking snippets, or claiming any
 * contents as your own will break the terms of the license, and
 * void any agreements with you, the third party. Thanks
 * ==================================================================
 */

package com.domnian.util;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class Util {

    public static String color(String m) {
        return m.replaceAll("(?i)&([0-9a-fk-or])", "\u00A7$1");
    }

    public static void printException(Exception e) {
        printException(e.getMessage(), e);
    }

    public static void printException(String m, Throwable e) {
        Logger.getGlobal().severe(m);
        String ex = ExceptionUtils.getFullStackTrace(e);
        for (String exl : ex.split("\n")) {
            Logger.getGlobal().severe(exl);
        }
    }

    public static void printException(Throwable dbg, int lines) {
        if (dbg == null) {
            return;
        }
        Logger.getGlobal().severe(dbg.getMessage());
        final StackTraceElement current = new Throwable().getStackTrace()[1];
        Logger.getGlobal().severe("c: " + current.getClassName() + ":" + current.getLineNumber());

        final StackTraceElement[] stack = dbg.getStackTrace();
        for (int i = 0; i < lines && i < stack.length; i++) {
            final StackTraceElement cur = stack[i];
            Logger.getGlobal().severe("  " + cur);
        }
    }

    public static void sendMsg(CommandSender s, String m) {
        s.sendMessage(Util.color(m));
    }

    public static void sendMsg(Player p, String m) {
        p.sendMessage(Util.color(m));
    }

    public static void printArgs(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Argument " + i + ": " + a[i]);
        }
    }

    public static void sendFMsg(Player p, String f, Object... a) {
        String str = String.format(f, a);
        Util.sendMsg(p, str);
    }

    public static void sendFMsg(CommandSender s, String f, Object... a) {
        String str = String.format(f, a);
        Util.sendMsg(s, str);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static Firework getFirework(Firework fw, int power) {
        FireworkMeta meta = fw.getFireworkMeta();
        meta.setPower(power);
        Random rand = new Random();
        int r = rand.nextInt(3);
        for (int i = 0; i < (r < 1 ? 1 : r); i++) {
            FireworkEffect.Builder b = FireworkEffect.builder();
            b.flicker(rand.nextBoolean());
            b.trail(rand.nextBoolean());
            switch (rand.nextInt(5)) {
                case 0:
                    b.with(FireworkEffect.Type.BALL);
                case 1:
                    b.with(FireworkEffect.Type.BALL_LARGE);
                case 2:
                    b.with(FireworkEffect.Type.BURST);
                case 3:
                    b.with(FireworkEffect.Type.CREEPER);
                case 4:
                    b.with(FireworkEffect.Type.STAR);
                default:
                    b.with(FireworkEffect.Type.BALL);
            }
            b.withColor(Color.fromRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            meta.addEffect(b.build());
        }
        fw.setFireworkMeta(meta);
        return fw;
    }

    public static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static Long parseLong(String value, Object def) {
        return Long.parseLong(value);
    }

    public static Integer parseInt(String value, Object def) {
        if ( !Util.isNumeric(value) ) {
            return Integer.parseInt(String.valueOf(def));
        } else {
            return Integer.parseInt(value);
        }
    }

    public static Float parseFloat(String value, Object def) {
        if ( Float.isNaN(Float.parseFloat(value)) || Float.isInfinite(Float.parseFloat(value)) ) {
            return Float.parseFloat(String.valueOf(def));
        } else {
            return Float.parseFloat(value);
        }
    }

    public static Double parseDouble(String value, Object def) {
        if ( Double.isNaN(Double.parseDouble(value)) || Double.isInfinite(Double.parseDouble(value)) ) {
            return Double.parseDouble(String.valueOf(def));
        } else {
            return Double.parseDouble(value);
        }
    }

    public static void log(String msg) {
        Logger.getGlobal().log(Level.INFO, msg);
    }

    /* Start IRCBot Console Coloring System */
    public static void success(String msg) {
        System.out.println("\033[7;32m" + msg + "\033[0m");
    }

    public static void severe(String msg) {
        System.err.println("\033[7;31m" + msg + "\033[0m");
    }

    public static void error(String msg) {
        System.err.println("\033[7;33m" + msg + "\033[0m");
    }

    public static void info(String msg) {
        System.out.println("\033[0;37m" + msg + "\033[0m");
    }

    public static void debug(String msg) {
        System.out.println("\033[0;35m" + msg + "\033[0m");
    }
    /* End IRCBot Console Coloring System */

}