package com.leaper.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "first")
    private String first;

    @Column(name = "second")
    private String second;

    @Column(name = "third")
    private String third;

    @Column(name = "fourth")
    private String fourth;

    @Column(name = "fifth")
    private String fifth;

    @Column(name = "sixth")
    private String sixth;

    @Column(name = "seventh")
    private String seventh;

    @Column(name = "eighth")
    private String eighth;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Timetable(){
    }

    public Timetable(String dayOfWeek) {
        this.setDayOfWeek(dayOfWeek);
    }
}
