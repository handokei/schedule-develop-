package com.example.schedule.controller;


import com.example.schedule.dto.SignUpRequestDto;
import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.schedule.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(requestDto.getUserName(), requestDto.getPassword(), requestDto.getUserEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    //단건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userService.findById(userId);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}
