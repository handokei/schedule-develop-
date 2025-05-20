package entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

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
    @JoinColumn(name = "userId")
    private User user;

    public  Schedule(String planTitle, String planContents){
        this.planTitle = planTitle;
        this.planContents = planContents;
    }

    //JPA가 이용
    public void Schedule() {}

    public void newUser(User user){
        this.user = user;
    }

}
