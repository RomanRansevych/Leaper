package com.leaper.controllers;

import com.leaper.services.homework.HomeworkService;
import com.leaper.services.timetable.TimetableService;
import com.leaper.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceController {

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    HomeworkService homeworkService;
}
