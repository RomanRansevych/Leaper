package com.leaper.controller;

import com.leaper.entity.Timetable;
import com.leaper.entity.User;
import com.leaper.service.timetable.TimetableService;
import com.leaper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

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
        user.setRole("Student");
        user.setEnabled(true);
        user.setFirstName("FirstName");
        user.setSecondName("SecondName");
        user.setLastName("LastName");
        user.setPhoneNumber("+380000000000");
        user.setEmail("youremail@gmail.com");

        Timetable monday = new Timetable("Monday");
//        timetableService.saveTimetable(monday);
        Timetable tuesday = new Timetable("Tuesday");
//        timetableService.saveTimetable(tuesday);
        Timetable wednesday = new Timetable("Wednesday");
//        timetableService.saveTimetable(wednesday);
        Timetable thursday = new Timetable("Thursday");
//        timetableService.saveTimetable(thursday);
        Timetable friday = new Timetable("Friday");
//        timetableService.saveTimetable(friday);
        Timetable saturday = new Timetable("Saturday");
//        timetableService.saveTimetable(saturday);
        Timetable sunday = new Timetable("Sunday");
//        timetableService.saveTimetable(sunday);

        user.addTimetable(monday);
        user.addTimetable(tuesday);
        user.addTimetable(wednesday);
        user.addTimetable(thursday);
        user.addTimetable(friday);
        user.addTimetable(saturday);
        user.addTimetable(sunday);

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
