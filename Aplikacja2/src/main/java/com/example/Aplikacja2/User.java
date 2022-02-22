package com.example.Aplikacja2;

import lombok.*;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.Id;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private int age;
    private String city;


    public User() {
    }

    public User(String username, int age, String city){
        this.username = username;
        this.age = age;
        this.city = city;

    }

    public User(String username, String city) {

    }
}
