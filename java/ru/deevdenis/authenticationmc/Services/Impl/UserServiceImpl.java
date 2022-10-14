package ru.deevdenis.authenticationmc.Services.Impl;

import com.sun.istack.NotNull;
import ru.deevdenis.authenticationmc.DAO.Impl.UserDAOImpl;
import ru.deevdenis.authenticationmc.DAO.UserDAO;
import ru.deevdenis.authenticationmc.Models.User;
import ru.deevdenis.authenticationmc.Services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = new UserDAOImpl();
    }

    @Override
    public void save(@NotNull User user) { userDAO.save(user);}

    @Override
    public User findByName(@NotNull String name) {
        List<User> userList = userDAO.findByName(name);
        return userList.stream().findFirst().orElse(new User());
    }
}
