package it.loneliness.mc.commandslistplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import it.loneliness.mc.commandslistplugin.Controller.CommandHandler;
import it.loneliness.mc.commandslistplugin.Model.LogHandler;

public class CommandsListPlugin extends JavaPlugin {
    CommandHandler commandHandler;
    LogHandler logger;
    
    @Override
    public void onEnable() {
        logger = new LogHandler(getLogger());
        logger.info("Initializing!");

        commandHandler = new CommandHandler(this, logger);
    }
    @Override
    public void onDisable() {
        logger.info("Disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return commandHandler.onCommand(sender, cmd, label, args);
    }
}