package com.leaper.service.homework;

import com.leaper.entity.Homework;
import com.leaper.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImplements implements HomeworkService {

    @Autowired
    HomeworkRepository homeworkRepository;

    @Override
    public Homework saveHomework(Homework homework) {
        homeworkRepository.save(homework);
        return homework;
    }

    @Override
    public List<Homework> getAllByUser_Id(int userId) {
        return homeworkRepository.getAllByUser_Id(userId);
    }

    @Override
    public void deleteHomework(int id) {
        homeworkRepository.deleteById(id);
    }
}
