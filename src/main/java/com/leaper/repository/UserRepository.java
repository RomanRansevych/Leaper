package com.leaper.repository;

import com.leaper.entity.User;
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
}
