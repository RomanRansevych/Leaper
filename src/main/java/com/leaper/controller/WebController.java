package com.leaper.controller;

import com.leaper.entity.Homework;
import com.leaper.entity.Timetable;
import com.leaper.service.homework.HomeworkService;
import com.leaper.service.timetable.TimetableService;
import com.leaper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@EnableWebSecurity
@RequestMapping("/leaper")
@Controller
public class WebController {

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    HomeworkService homeworkService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("error", error != null);

        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("allUsername", userService.getAllUsername());

        return "registration";
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User userSecurity, Model model) {
        com.leaper.entity.User user = userService.getUserByLogin(userSecurity.getUsername());
        model.addAttribute("user", userService.getUser(user.getId()));

        return "profile";
    }

    @GetMapping("/timetable")
    public String timetable(@AuthenticationPrincipal User userSecurity, Model model) {
        com.leaper.entity.User user = userService.getUserByLogin(userSecurity.getUsername());
        List<Timetable> userTimetable = timetableService.getUserTimetable(user.getId());

        Timetable mondayTimetable = userTimetable.get(0);
        Timetable tuesdayTimetable = userTimetable.get(1);
        Timetable wednesdayTimetable = userTimetable.get(2);
        Timetable thursdayTimetable = userTimetable.get(3);
        Timetable fridayTimetable = userTimetable.get(4);
        Timetable saturdayTimetable = userTimetable.get(5);
        Timetable sundayTimetable = userTimetable.get(6);

        model.addAttribute("mondayTimetable", mondayTimetable);
        model.addAttribute("tuesdayTimetable", tuesdayTimetable);
        model.addAttribute("wednesdayTimetable", wednesdayTimetable);
        model.addAttribute("thursdayTimetable", thursdayTimetable);
        model.addAttribute("fridayTimetable", fridayTimetable);
        model.addAttribute("saturdayTimetable", saturdayTimetable);
        model.addAttribute("sundayTimetable", sundayTimetable);

        model.addAttribute("user", user);

        return "timetable";
    }

    @GetMapping("/timetable/edit")
    public String editTimetable(@AuthenticationPrincipal User userSecurity, Model model) {
        com.leaper.entity.User user = userService.getUserByLogin(userSecurity.getUsername());
        List<Timetable> userTimetable = timetableService.getUserTimetable(user.getId());

        Timetable mondayTimetable = userTimetable.get(0);
        Timetable tuesdayTimetable = userTimetable.get(1);
        Timetable wednesdayTimetable = userTimetable.get(2);
        Timetable thursdayTimetable = userTimetable.get(3);
        Timetable fridayTimetable = userTimetable.get(4);
        Timetable saturdayTimetable = userTimetable.get(5);
        Timetable sundayTimetable = userTimetable.get(6);

        model.addAttribute("mondayTimetable", mondayTimetable);
        model.addAttribute("tuesdayTimetable", tuesdayTimetable);
        model.addAttribute("wednesdayTimetable", wednesdayTimetable);
        model.addAttribute("thursdayTimetable", thursdayTimetable);
        model.addAttribute("fridayTimetable", fridayTimetable);
        model.addAttribute("saturdayTimetable", saturdayTimetable);
        model.addAttribute("sundayTimetable", sundayTimetable);

        model.addAttribute("user", user);

        return "edit-timetable";
    }

    @GetMapping("/homework")
    public String homework(@AuthenticationPrincipal User userSecurity, Model model) {
        com.leaper.entity.User user = userService.getUserByLogin(userSecurity.getUsername());
        List<Homework> homeworkList = homeworkService.getAllByUser_Id(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("homework", homeworkList);

        return "homework";
    }
}
