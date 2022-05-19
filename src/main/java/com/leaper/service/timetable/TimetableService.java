package com.leaper.service.timetable;

import com.leaper.entity.Timetable;

import java.util.List;

public interface TimetableService {

    void saveTimetable(Timetable timetable);

    List<Timetable> getUserTimetable(int userId);
}
