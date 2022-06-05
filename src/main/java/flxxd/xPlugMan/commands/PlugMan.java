package flxxd.xPlugMan.commands;

import com.google.common.collect.Lists;
import flxxd.xPlugMan.Main;
import flxxd.xPlugMan.helpers.AbstractCommand;
import flxxd.xPlugMan.helpers.Tool;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PlugMan extends AbstractCommand {
    public PlugMan () {
        super("plugman");
    }

    @Override
    public void execute (CommandSender sender, String label, String[] args) {
        Player send3r = Bukkit.getPlayer(sender.getName());
        assert send3r != null;

        if (args.length == 0) {
            send3r.sendActionBar(
                    Main.getValue("actionBars.global.noArguments")
            );
        }

        if (args[0].equalsIgnoreCase("enable")) {
            if (args.length == 1) {
                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.noEnoughArguments")
                );
            }

            Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);

            if (args[1].equals("all")) {
                Tool.enableAll();

                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.enable.all")
                );
            } else {
                Tool.enable(plugin);

                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.enable.once")
                                .replace("%plugin%", args[1])
                );
            }

            return;
        }

        if (args[0].equalsIgnoreCase("disable")) {
            if (args.length == 1) {
                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.noEnoughArguments")
                );
            }

            Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);

            if (args[1].equals("all")) {
                Tool.disableAll();

                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.disable.all")
                );
            } else {
                Tool.disable(plugin);

                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.disable.once")
                                .replace("%plugin%", args[1])
                );
            }

            return;
        }

        if (args[0].equalsIgnoreCase("restart")) {
            if (args.length == 1) {
                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.noEnoughArguments")
                );
            }

            Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);

            if (args[1].equals("all")) {
                Tool.restartAll();

                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.restart.all")
                );
            } else {
                Tool.restart(plugin);

                send3r.sendActionBar(
                        Main.getValue("actionBars.loader.restart.once")
                                .replace("%plugin%", args[1])
                );
            }

            return;
        }

        send3r.sendActionBar(Main.getValue("actionBars.global.unknownCommand"));
    }

    public List<String> complete (CommandSender sender, String[] args) {
        if (args.length == 1) return Lists.newArrayList("enable", "disable", "restart");
        if (args.length == 2 && (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("restart"))) return Lists.newArrayList("all");

        return Lists.newArrayList();
    }
}