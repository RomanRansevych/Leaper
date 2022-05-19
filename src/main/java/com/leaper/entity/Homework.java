package com.leaper.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private String date;

    @Column(name = "subject")
    private String subject;

    @Column(name = "homework")
    private String homework;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homework_user_id")
    private User user;
}
