package com.leaper.services.timetable;

import com.leaper.entities.Timetable;

import java.util.List;

public interface TimetableService {
    List<Timetable> getUserTimetable(int userId);

    Timetable updateTimetable(String first, String second, String third, String fourth, String fifth,
                              String sixth, String seventh, String eighth, int id);
}
