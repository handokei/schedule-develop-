package com.example.schedule.repository;

import com.example.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<User, Long> {
   default User findByIdOrElseThrow(Long userId) {
       return findById(userId).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND));
   }
}
