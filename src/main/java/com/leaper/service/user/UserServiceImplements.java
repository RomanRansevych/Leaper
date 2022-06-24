package com.leaper.service.user;

import com.leaper.entity.Timetable;
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
        user.setRole("ROLE_STUDENT");
        user.setEnabled(true);
        user.setFirstName("FirstName");
        user.setSecondName("SecondName");
        user.setLastName("LastName");
        user.setPhoneNumber("+380000000000");
        user.setEmail("youremail@gmail.com");

        Timetable monday = new Timetable("Monday");
        Timetable tuesday = new Timetable("Tuesday");
        Timetable wednesday = new Timetable("Wednesday");
        Timetable thursday = new Timetable("Thursday");
        Timetable friday = new Timetable("Friday");
        Timetable saturday = new Timetable("Saturday");
        Timetable sunday = new Timetable("Sunday");

        user.addTimetable(monday);
        user.addTimetable(tuesday);
        user.addTimetable(wednesday);
        user.addTimetable(thursday);
        user.addTimetable(friday);
        user.addTimetable(saturday);
        user.addTimetable(sunday);

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
