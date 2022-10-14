package ru.deevdenis.authenticationmc.DAO;

import ru.deevdenis.authenticationmc.Models.User;

import java.util.List;

public interface UserDAO {
    void save(User user);

    List<User> findByName(String name);
}
