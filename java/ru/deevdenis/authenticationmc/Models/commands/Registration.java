package ru.deevdenis.authenticationmc.Models.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.deevdenis.authenticationmc.Configuration.PluginUtils;
import ru.deevdenis.authenticationmc.Models.User;
import ru.deevdenis.authenticationmc.Services.Impl.UserServiceImpl;
import ru.deevdenis.authenticationmc.Services.UserService;

public class Registration implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        UserService userService = new UserServiceImpl();

        Player player = PluginUtils.valueOf(sender);
        String name = player.getDisplayName();
        String password = args[0];

        User user = userService.findByName(name);

        if (!user.getName().equals(name) || user.getName() == null) {
            user.setName(name);
            user.setPassword(PluginUtils.hashPassword(password));

            userService.save(user);

            sender.sendMessage(String.format("Уважаемый, %s. Вы успешно зарегистрированы!", name));
            return true;
        }

        sender.sendMessage(String.format("Уважаемый, %s. Вы уже зарегистрированы!", name));
        return true;
    }
}
