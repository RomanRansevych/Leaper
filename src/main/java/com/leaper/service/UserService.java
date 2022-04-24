package com.leaper.service;

import com.leaper.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

//    List<User> findAllByName(String name);
}
