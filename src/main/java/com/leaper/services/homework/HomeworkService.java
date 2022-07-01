package com.leaper.services.homework;

import com.leaper.entities.Homework;

import java.util.List;

public interface HomeworkService {

    Homework saveHomework(Homework homework);

    List<Homework> getAllByUser_Id(int userId);

    void deleteHomework(int id);
}
