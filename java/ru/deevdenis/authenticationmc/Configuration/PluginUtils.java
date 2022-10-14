package ru.deevdenis.authenticationmc.Configuration;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PluginUtils {
    private static List<Player> freezePlayerList = new ArrayList<Player>();

    public static Player valueOf(CommandSender sender) { return (Player) sender; }

    public static String hashPassword(String password) {
        int hash = Objects.hashCode(password);
        return String.valueOf(hash);
    }

    public static void addFreezePlayer(Player player) {
        PluginUtils.freezePlayerList.add(player);
    }

    public static void removeFreezePlayer(Player player) {
        PluginUtils.freezePlayerList.remove(player);
    }

    public static List<Player> getFreezePlayerList() { return freezePlayerList; }

    public static void setFreezePlayerList(List<Player> freezePlayerList) {
        PluginUtils.freezePlayerList = freezePlayerList;
    }
}
