package com.leaper.repository;

import com.leaper.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
    List<Timetable> getTimetableByUser_Id(int userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE timetable " +
            "SET first=?1, second=?2, third=?3, fourth=?4, fifth=?5, sixth=?6, seventh=?7, eighth=?8 " +
            "WHERE id = ?9", nativeQuery = true)
    void updateTimetable(String first, String second, String third, String fourth,
                         String fifth, String sixth, String seventh, String eighth,
                         int id);
}
