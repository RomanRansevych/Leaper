package com.leaper.controllers;

import com.leaper.entities.Homework;
import com.leaper.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeworkRestController extends ServiceController {

    @PostMapping("/homework/create")
    public Homework createHomework(@AuthenticationPrincipal org.springframework.security.core.userdetails.User userSecurity, @RequestBody Homework homework) {
        User user = userService.getUserByLogin(userSecurity.getUsername());
        homework.setUser(user);
        homeworkService.saveHomework(homework);

        return homework;
    }

    @DeleteMapping("/homework/delete/{id}")
    public void deleteHomework(@PathVariable int id) {
        homeworkService.deleteHomework(id);
    }
}
