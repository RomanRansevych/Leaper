package com.leaper.services.user;

import com.leaper.entities.User;

import java.util.List;

public interface UserService {
    List<String> getAllUsername();

    void updateUser(String login, String password, String firstName, String secondName,
                    String lastName, String phoneNumber, String email, int id);

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    User getUserByLogin(String login);
}
