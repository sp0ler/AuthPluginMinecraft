package ru.deevdenis.authenticationmc.Models.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.deevdenis.authenticationmc.Configuration.PluginUtils;

import java.util.List;

public class FreezePlayer implements Listener {

    private static FreezePlayer freezePlayer;

    private FreezePlayer() {}

    public static FreezePlayer getInstance() {
        if (freezePlayer == null) {
            freezePlayer = new FreezePlayer();
        }

        return freezePlayer;
    }

    @EventHandler
    public void freezePlayer(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        List<Player> freezePlayerList = PluginUtils.getFreezePlayerList();

        if (freezePlayerList.contains(player)) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
            event.getHandlers().unregister(this);
        }

        System.out.println("PlayerMoveEvent method!");

    }
}
