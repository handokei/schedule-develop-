package com.example.schedule.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(nullable = false)
    private String planTitle;

    @Column(columnDefinition = "longtext")
    private String planContents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {

    }

    public  Schedule(String planTitle, String planContents){
        this.planTitle = planTitle;
        this.planContents = planContents;
    }

    public void setnewUser(User user){
        this.user = user;
    }

}
