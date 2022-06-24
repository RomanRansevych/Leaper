package com.leaper.controller;

import com.leaper.service.homework.HomeworkService;
import com.leaper.service.timetable.TimetableService;
import com.leaper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceController {

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    HomeworkService homeworkService;
}
