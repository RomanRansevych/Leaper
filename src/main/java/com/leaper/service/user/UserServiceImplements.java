package com.leaper.service.user;

import com.leaper.entity.User;
import com.leaper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<String> getAllUsername() {
        return new ArrayList<>(userRepository.getAllUsername());
    }

    @Override
    public void updateUser(String login, String password, String firstName, String secondName,
                           String lastName, String phoneNumber, String email, int id) {
        userRepository.updateUser(login, password, firstName, secondName, lastName, phoneNumber, email, id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        User user = null;
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        return user;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
