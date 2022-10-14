package ru.deevdenis.authenticationmc.Services;

import ru.deevdenis.authenticationmc.Models.User;

public interface UserService {
    void save(User user);

    User findByName(String name);
}
