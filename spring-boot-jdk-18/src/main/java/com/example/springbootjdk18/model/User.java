package com.example.springbootjdk18.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "aw_user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lname")
    private String name;

    @Column(name = "registration_step")
    private String status;

    @Column(name = "email_id")
    private String email;
}
