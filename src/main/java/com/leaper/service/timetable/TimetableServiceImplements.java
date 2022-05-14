package com.leaper.service.timetable;

import com.leaper.entity.Timetable;
import com.leaper.entity.User;
import com.leaper.repository.TimetableRepository;
import com.leaper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TimetableServiceImplements implements TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    @Override
    public void saveTimetable(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    @Override
    public List<Timetable> getUserTimetable(int id) {
        return timetableRepository.findAllById(Collections.singleton(id));
    }
}
