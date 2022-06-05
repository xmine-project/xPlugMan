package flxxd.xPlugMan.helpers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Tool {
    public static void enable (Plugin plugin) {
        if (plugin != null && !plugin.isEnabled()) {
            if (plugin.getName().equals("xPlugMan") || plugin.getName().equals("ViaVersion") || plugin.getName().equals("ViaBackwards")) return;

            Bukkit.getPluginManager().enablePlugin(plugin);
        }
    }

    public static void enableAll () {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            enable(plugin);
        }
    }


    public static void disable (Plugin plugin) {
        if (plugin != null && plugin.isEnabled()) {
            if (plugin.getName().equals("xPlugMan") || plugin.getName().equals("ViaVersion") || plugin.getName().equals("ViaBackwards")) return;

            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }

    public static void disableAll () {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            disable(plugin);
        }
    }


    public static void restart (Plugin plugin) {
        if (plugin != null) {
            disable(plugin);
            enable(plugin);
        }
    }

    public static void restartAll () {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            disable(plugin);
            enable(plugin);
        }
    }
}
