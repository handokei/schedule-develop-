package com.example.schedule.controller;


import com.example.schedule.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.schedule.service.UserService;

import java.util.List;

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

    //전체조회
    @GetMapping
    public ResponseEntity<List<UserListResponseDto>> findAll() {
        List<UserListResponseDto> userResponseDtoList = userService.findAll();

        return new ResponseEntity<>(userResponseDtoList,HttpStatus.OK);
    }

    //단건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userService.findById(userId);

        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    //수정
    @PutMapping("/{userId}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long userId,
            @RequestBody UpdateRequestDto dto
            ) {
        userService.updatePassword(userId,
                dto.getOldPassword(),dto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
