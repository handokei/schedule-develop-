package entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


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
            String userName,String userEmail,
            String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;

    }

    public User() {

    }
}
