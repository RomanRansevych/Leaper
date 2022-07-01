package com.leaper.controllers;

import com.leaper.entities.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController extends ServiceController {

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user) {
        userService.saveUser(user);

        return user;
    }

    @PatchMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user.getLogin(), user.getPassword(), user.getFirstName(), user.getSecondName(),
                user.getLastName(), user.getPhoneNumber(), user.getEmail(), user.getId());

        return user;
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);

        return "User deleted with id = " + "'" + id + "'";
    }
}
