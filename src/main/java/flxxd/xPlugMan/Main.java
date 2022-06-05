package flxxd.xPlugMan;

import flxxd.xPlugMan.commands.PlugMan;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable () {
        instance = this;
        saveDefaultConfig();

        new PlugMan();
    }

    @Override
    public void onDisable () {
        // Plugin shutdown logic
    }

    public static Main getInstance () {
        return instance;
    }
    public static String getValue (String value) {
        return Main.getInstance().getConfig().getString(value).replace("&", "§");
    }
}