package com.example.schedule.service;


import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.schedule.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String password, String userEmail) {
        User user = new User(userName, password, userEmail);
        User savedUser = userRepository.save(user);
        return new SignUpResponseDto(savedUser.getUserId(),savedUser.getUserName(),savedUser.getUserEmail());
    }


}
