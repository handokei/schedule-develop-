package com.example.schedule.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class SignUpRequestDto {

    @NotBlank
    @Size(min = 2, max =8)
    @Pattern(regexp = "^[가-힣]*$",
            message = "이름은 한글 2~8자여야 합니다.")
    private final String userName;
    @NotNull
    @Size(min = 4, max =120)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "비밀번호 형식이 올바르지 않습니다. 4자 이상, 대소문자 포함, 숫자 및 특수문자(@$!%*?&#) 포함")
    private final String password;
    @Email
    @Pattern(regexp =  "^[\\w!#$%&'*+/=?`{|}~^.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$",
            message = "이메일 형식이 올바르지 않습니다.")
    private final String userEmail;

    public SignUpRequestDto(String userName, String password, String userEmail) {
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
    }
}
