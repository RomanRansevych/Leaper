package com.leaper.repository;

import com.leaper.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByLoginAndPassword(String login, String password);

    Optional<User> getUserByLogin(@NonNull String login);
}
