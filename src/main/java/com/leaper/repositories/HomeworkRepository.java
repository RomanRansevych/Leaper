package com.leaper.repositories;

import com.leaper.entities.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    List<Homework> getAllByUser_Id(int userId);
}
