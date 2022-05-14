package com.leaper.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Timetable> timetableList;

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public void addTimetable(Timetable timetable){
        if (timetableList == null) {
            timetableList = new ArrayList<>();
        }
        timetableList.add(timetable);
        timetable.setUser(this);
    }
}
