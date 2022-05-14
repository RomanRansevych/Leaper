package com.leaper.service.timetable;

import com.leaper.entity.Timetable;
import com.leaper.entity.User;

import java.util.List;

public interface TimetableService {

    void saveTimetable(Timetable timetable);

    List<Timetable> getUserTimetable(int id);


}
