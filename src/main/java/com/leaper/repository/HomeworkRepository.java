package com.leaper.repository;

import com.leaper.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    List<Homework> getAllByUser_Id(int userId);
}
