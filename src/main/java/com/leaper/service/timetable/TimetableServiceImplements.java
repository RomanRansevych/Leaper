package com.leaper.service.timetable;

import com.leaper.entity.Timetable;
import com.leaper.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableServiceImplements implements TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Override
    public List<Timetable> getUserTimetable(int id) {
        return timetableRepository.getTimetableByUser_Id(id);
    }

    @Override
    public Timetable updateTimetable(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eighth, int id) {
        timetableRepository.updateTimetable(first, second, third, fourth, fifth, sixth, seventh, eighth, id);

        return new Timetable();
    }
}
