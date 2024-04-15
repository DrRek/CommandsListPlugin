package it.loneliness.mc.commandslistplugin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * Misc helper methods relating to player notification
 */
public class Announcement {

    private static final String PREFIX_FORMAT_CODE = ChatColor.COLOR_CHAR+"l"; //bold
    private static final ChatColor PREFIX_COLOR = ChatColor.DARK_PURPLE;
    private static final ChatColor RESET_CODE = ChatColor.RESET;
    private static final String RAW_MESSAGE_PREFIX = "[CommandsListPlugin] ";

    public static void sendMessage(Player p, String message) {
        p.sendMessage(formatMessage(message));
    }

    private static String formatMessage(String message) {
        return String.format("%s%s%s%s%s", PREFIX_FORMAT_CODE, PREFIX_COLOR, RAW_MESSAGE_PREFIX, RESET_CODE, message);
    }

}
