package com.leaper.controller;

import com.leaper.entity.Homework;
import com.leaper.entity.Timetable;
import com.leaper.entity.User;
import com.leaper.service.homework.HomeworkService;
import com.leaper.service.timetable.TimetableService;
import com.leaper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    HomeworkService homeworkService;

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
        Timetable tuesday = new Timetable("Tuesday");
        Timetable wednesday = new Timetable("Wednesday");
        Timetable thursday = new Timetable("Thursday");
        Timetable friday = new Timetable("Friday");
        Timetable saturday = new Timetable("Saturday");
        Timetable sunday = new Timetable("Sunday");

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

    @PatchMapping("/timetable")
    public Timetable updateTimetable(@RequestBody Timetable timetable) {
        timetableService.updateTimetable(timetable.getFirst(), timetable.getSecond(), timetable.getThird(),
                timetable.getFourth(), timetable.getFifth(), timetable.getSixth(), timetable.getSeventh(),
                timetable.getEighth(), timetable.getId());

        return timetable;
    }

    @PatchMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user.getLogin(), user.getPassword(), user.getFirstName(), user.getSecondName(),
                user.getLastName(), user.getPhoneNumber(), user.getEmail(), user.getId());

        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);

        return "User deleted with id = " + "'" + id + "'";
    }
}
