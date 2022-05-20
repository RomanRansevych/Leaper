package com.leaper.service.user;

import com.leaper.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<String> getAllUsername();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    User getUserByLoginAndPassword(String login, String password);

    User getUserByLogin(String login);
}
