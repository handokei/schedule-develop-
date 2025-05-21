package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false,unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userEmail;


    public User (
            String userName,String password,
            String userEmail)
             {
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;

    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public User() {

    }
}
