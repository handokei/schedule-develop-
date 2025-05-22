package com.example.schedule.repository;

import com.example.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);

    Optional<User> findUserByUserEmail(String userEmail);

    default User findUserByUserNameOrElseThrow(String userName) {
        return findUserByUserName(userName).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    default User findByIdOrElseThrow(Long userId) {
       return findById(userId).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
   }


}
