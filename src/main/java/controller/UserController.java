package controller;


import dto.SignUpRequestDto;
import dto.SignUpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto dto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(dto.getUserName(), dto.getPassword(), dto.getUserEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }


}
