package ru.deevdenis.authenticationmc.Models.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.deevdenis.authenticationmc.Configuration.PluginUtils;

public class ConnectedPlayer implements Listener {

    private static ConnectedPlayer connectedPlayer;

    private ConnectedPlayer() {}

    public static ConnectedPlayer getInstance() {
        if (connectedPlayer == null) {
            connectedPlayer = new ConnectedPlayer();
        }

        return connectedPlayer;
    }

    @EventHandler
    public void freezePlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PluginUtils.addFreezePlayer(player);
    }

}
