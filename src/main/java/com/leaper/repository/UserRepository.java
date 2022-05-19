package com.leaper.repository;

import com.leaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByLoginAndPassword(String login, String password);

    User getUserByLogin(String login);
}
