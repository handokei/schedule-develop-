package com.example.schedule.service;


import com.example.schedule.dto.LoginResponseDto;
import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.dto.UserListResponseDto;
import com.example.schedule.dto.UserResponseDto;
import com.example.schedule.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.schedule.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String password, String userEmail) {
        User user = new User(userName, password, userEmail);
        User savedUser = userRepository.save(user);
        return new SignUpResponseDto(savedUser.getUserId(),savedUser.getUserName(),savedUser.getUserEmail());
    }

    public LoginResponseDto login(String userEmail,String password) {
        User user = userRepository.findUserByUserEmail(userEmail).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        if (user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return new LoginResponseDto(user.getUserId());


    }

    public UserResponseDto findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        //NPE방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
            User findUser = optionalUser.get();

            return new UserResponseDto(findUser.getUserName(), findUser.getUserEmail());

    }


    public List<UserListResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserListResponseDto::listDto).toList();
    }

    @Transactional
    public void updatePassword(Long userId, String oldPassword, String newPassword) {
       User findUser = userRepository.findByIdOrElseThrow(userId);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 일치하지 않습니다.");
        }

        findUser.updatePassword(newPassword);

    }

    public void deleteUser(Long userId) {

        User findUser = userRepository.findByIdOrElseThrow(userId);

        userRepository.delete(findUser);
    }


}
