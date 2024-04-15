package it.loneliness.mc.commandslistplugin.Controller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import it.loneliness.mc.commandslistplugin.Model.LogHandler;

public class CommandHandler {

    private Plugin plugin;
    private LogHandler logger;

    public CommandHandler(Plugin plugin, LogHandler logger) {
        this.plugin = plugin;
        this.logger = logger;
    }

    /**
     * Sends a message to the given CommandSender
     */
    private void sendMessage(CommandSender sender, String message) {
        if (sender instanceof Player) {
            Announcement.sendMessage((Player) sender, message);
        } else {
            sender.sendMessage(message);
        }
    }

    private boolean checkPermissionCommands(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("commandslistplugin.bypass")) {
                sendMessage(sender, "You are bypassing the allowed commands list");
            } else {
                sendMessage(sender, "You don't have permission to use this command.");
            }
        } else {
            sendMessage(sender, "Only players can use this command.");
        }
        return true;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("testt")) {
            return checkPermissionCommands(sender, cmd, label, args);
        } 
        
        // if (cmd.getName().equalsIgnoreCase("ch") && args.length == 1 && args[0].equalsIgnoreCase("despawnall")) {
        //     return despawnAllMobsCommand(sender, cmd, label, args);
        // }

        // if no command is found
        return false;
    }
}
