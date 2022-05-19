package com.leaper.service.homework;

import com.leaper.entity.Homework;

import java.util.List;

public interface HomeworkService {

    Homework saveHomework(Homework homework);

    List<Homework> getAllByUser_Id(int userId);

    void deleteHomework(int id);
}
