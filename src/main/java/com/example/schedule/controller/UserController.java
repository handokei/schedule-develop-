package com.example.schedule.controller;


import com.example.schedule.commom.Const;
import com.example.schedule.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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


    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> createLogin(
            @Valid
            @RequestBody SignUpRequestDto dto,
            HttpServletRequest request
    ) {
        SignUpResponseDto responseDto = userService.signUp(dto.getUserName(), dto.getPassword(), dto.getUserEmail());

        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);

    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> userLogin(
            @Valid
            @RequestBody LoginRequestDto dto,
            HttpServletRequest request
    ) {
        LoginResponseDto loginResponseDto = userService.login(dto.getUserEmail(), dto.getPassword());
        //세션 가져오기
        HttpSession session = request.getSession();
        //세션 저장하기
        session.setAttribute(Const.LOGIN_USER,loginResponseDto);

        return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
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
