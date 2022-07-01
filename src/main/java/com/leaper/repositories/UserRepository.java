package com.leaper.repositories;

import com.leaper.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByLoginAndPassword(String login, String password);

    User getUserByLogin(String login);

    @Modifying
    @Transactional
    @Query(value = "SELECT login FROM users", nativeQuery = true)
    List<String> getAllUsername();

    @Modifying
    @Transactional
    @Query(value = "UPDATE users " +
            "SET login=?1, password=?2, first_name=?3, second_name=?4, last_name=?5, phone_number=?6, email=?7 " +
            "WHERE id=?8", nativeQuery = true)
    void updateUser(String login, String password, String firstName, String secondName,
                            String lastName, String phoneNumber, String email, int id);
}
