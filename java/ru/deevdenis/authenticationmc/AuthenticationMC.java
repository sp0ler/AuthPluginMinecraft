package ru.deevdenis.authenticationmc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.deevdenis.authenticationmc.Configuration.HibernateUtil;
import ru.deevdenis.authenticationmc.Models.commands.Authentication;
import ru.deevdenis.authenticationmc.Models.commands.Registration;
import ru.deevdenis.authenticationmc.Models.events.ConnectedPlayer;
import ru.deevdenis.authenticationmc.Models.events.FreezePlayer;

public class AuthenticationMC extends JavaPlugin {

    @Override
    public void onLoad() {
        HibernateUtil.getSessionFactory();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(ConnectedPlayer.getInstance(), this);
        Bukkit.getPluginManager().registerEvents(FreezePlayer.getInstance(), this);

        getCommand("authentication").setExecutor(new Authentication());
        getCommand("registration").setExecutor(new Registration());
    }

    @Override
    public void onDisable() {
        HibernateUtil.closeSessionFactory();
    }

}
