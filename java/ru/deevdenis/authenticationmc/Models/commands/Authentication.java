package ru.deevdenis.authenticationmc.Models.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.deevdenis.authenticationmc.Configuration.PluginUtils;
import ru.deevdenis.authenticationmc.Models.User;
import ru.deevdenis.authenticationmc.Services.Impl.UserServiceImpl;
import ru.deevdenis.authenticationmc.Services.UserService;

public class Authentication implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        UserService userService = new UserServiceImpl();

        Player player = PluginUtils.valueOf(sender);
        String name = player.getDisplayName();
        String password = args[0];

        User user = userService.findByName(name);

        if (user.getName().equals(name) && user.getPassword().equals(PluginUtils.hashPassword(password))) {
            PluginUtils.removeFreezePlayer(player);
            sender.sendMessage(String.format("Уважаемый, %s. Вы успешно вошли на сервер!", name));
            return true;
        }

        sender.sendMessage(String.format("Уважаемый, %s. Вы ввели неправильно пароль!", name));
        return true;
    }
}
