package com.leaper.controller;

import com.leaper.entity.Homework;
import com.leaper.entity.Timetable;
import com.leaper.entity.User;
import com.leaper.service.homework.HomeworkService;
import com.leaper.service.timetable.TimetableService;
import com.leaper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    HomeworkService homeworkService;

//    @GetMapping("/users")
//    public List<User> showAllUsers() {
//        return userService.getAllUsers();
//    }

//    @GetMapping("/users/{id}")
//    public User getUser(@PathVariable int id) {
//        return userService.getUser(id);
//    }

    /*
    Разобрать тут, сделать адекватное добавление в лист!!!!!!!!!!
     */
    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        user.setRole("ROLE_STUDENT");
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

    @PostMapping("/homework")
    public Homework addNewHomework(@AuthenticationPrincipal org.springframework.security.core.userdetails.User userSecurity, @RequestBody Homework homework) {
        com.leaper.entity.User user = userService.getUserByLogin(userSecurity.getUsername());
        homework.setUser(user);
        homeworkService.saveHomework(homework);

        return homework;
    }

    @DeleteMapping("/homework/{id}")
    public void deleteHomework(@PathVariable int id) {
        homeworkService.deleteHomework(id);
    }

//    @PutMapping("/users")
//    public User updateUser(@RequestBody User user) {
//        userService.saveUser(user);
//
//        return user;
//    }
//
//    @DeleteMapping("/users/{id}")
//    public String deleteUser(@PathVariable int id) {
//        userService.deleteUser(id);
//
//        return "User deleted with id = " + "'" + id + "'";
//    }
}
