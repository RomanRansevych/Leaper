package com.leaper.service.user;

import com.leaper.entity.User;

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
