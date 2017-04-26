package com.domnian.mcutils.config;

import com.google.common.base.Throwables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Pattern;

public class MagicConfig {

    private static final Pattern SPACE = Pattern.compile(" ");
    private static final Pattern NOT_NUMERIC = Pattern.compile("[^-\\d.]");
    public static YamlConfiguration config;
    static int configVersion;
    static Map<String, Command> commands;
    private static File CONFIG_FILE;

    public MagicConfig(Plugin owner, String name, Class<? extends MagicConfig> clazz, int version) {
        CONFIG_FILE = new File(owner.getDataFolder(), name + ".yml");
        config = new YamlConfiguration();
        try {
            config.load(CONFIG_FILE);
        } catch (IOException ignored) {
        } catch (InvalidConfigurationException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not load " + name + ", please correct your syntax errors", ex);
            throw Throwables.propagate(ex);
        }
        config.options().copyDefaults(true);
        commands = new HashMap<>();
        configVersion = getInt("config-version", version);
        set("config-version", version);
        readConfig(clazz, null);
    }

    private static void readConfig(Class<?> clazz, String subSection) {
        for (Field field : clazz.getDeclaredFields()) {
            if ((Modifier.isPublic(field.getModifiers())) && (Modifier.isStatic(field.getModifiers()))) {
                try {
                    field.setAccessible(true);
                    Object def = field.get(null);
                    ConfigNode node = field.getAnnotation(ConfigNode.class);
                    if (node != null) {
                        String nodeName = "." + node.value();
                        String key = subSection != null ? subSection + nodeName : nodeName;
                        config.addDefault(key, def);
                        field.set(null, config.get(key, def));
                    }
                } catch (Exception e) {
                    Bukkit.getLogger().log(Level.SEVERE, "Error Setting Field " + field, e);
                }
            }
        }

        for (Class inner : clazz.getDeclaredClasses()) {
            if ((Modifier.isPublic(inner.getModifiers())) && (Modifier.isStatic(inner.getModifiers()))) {
                ConfigSection section = (ConfigSection) inner.getAnnotation(ConfigSection.class);
                if (section != null) readConfig(inner, section.value());
            }
        }

        save();
    }

    private static Type getParamType(Field field) {
        if (Collection.class.isAssignableFrom(field.getType())) {
            Type type = field.getGenericType();
            if ((type instanceof ParameterizedType)) {
                ParameterizedType paramType = (ParameterizedType)type;
                Type[] argTypes = paramType.getActualTypeArguments();
                if (argTypes.length > 0) return argTypes[0];
            }
        }
        return null;
    }

    public static int getSeconds(String str) {
        try {
            str = SPACE.matcher(str).replaceAll("");
            char unit = str.charAt(str.length() - 1);
            str = NOT_NUMERIC.matcher(str).replaceAll("");
            double num = Double.parseDouble(str);
            switch (unit) {
                case 'd':
                    return (int)(num * 86400.0D);
                case 'h':
                    return (int)(num * 3600.0D);
                case 'm':
                    return (int)(num * 60.0D);
                case 's':
                    return (int)num;
            }
        } catch (NumberFormatException ignored) {}
        return 0;
    }

    public static String timeSummary(int seconds) {
        String time = "";
        if (seconds > 86400) {
            time = time + TimeUnit.SECONDS.toDays(seconds) + "d";
            seconds %= 86400;
        }
        if (seconds > 3600) {
            time = time + TimeUnit.SECONDS.toHours(seconds) + "h";
            seconds %= 3600;
        }
        if (seconds > 0) {
            time = time + TimeUnit.SECONDS.toMinutes(seconds) + "m";
        }
        return time;
    }

    public static void set(String path, Object val) {
        config.set(path, val);
    }

    public static boolean getBoolean(String path, boolean def) {
        config.addDefault(path, def);
        return config.getBoolean(path, config.getBoolean(path));
    }

    public static double getDouble(String path, double def) {
        config.addDefault(path, def);
        return config.getDouble(path, config.getDouble(path));
    }

    public static float getFloat(String path, float def) {
        return (float)getDouble(path, def);
    }

    public static int getInt(String path, int def) {
        config.addDefault(path, def);
        return config.getInt(path, config.getInt(path));
    }

    public static <T> List getList(String path, T def) {
        config.addDefault(path, def);
        return config.getList(path, config.getList(path));
    }

    public static String getString(String path, String def) {
        config.addDefault(path, def);
        return config.getString(path, config.getString(path));
    }

    public static void save() {
        try {
            config.save(CONFIG_FILE);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save " + CONFIG_FILE, e);
        }
    }
}