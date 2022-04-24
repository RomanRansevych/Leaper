package com.leaper.controller;

import com.leaper.entity.User;
import com.leaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        user.setStatus(101);
        user.setFirstName("FirstName");
        user.setSecondName("SecondName");
        user.setLastName("LastName");
        user.setPhoneNumber("+380000000000");
        user.setEmail("youremail@gmail.com");
        userService.saveUser(user);

        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);

        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);

        return "User deleted with id = " + "'" + id + "'";
    }
}
