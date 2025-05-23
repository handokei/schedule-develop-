package com.example.schedule.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class UpdateRequestDto {

    @NotNull
    @Range(min = 4, max =120)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "비밀번호 형식이 올바르지 않습니다. 4자 이상, 대소문자 포함, 숫자 및 특수문자(@$!%*?&#) 포함")
    private final String oldPassword;

    @NotNull
    @Range(min = 4, max =120)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
            message = "비밀번호 형식이 올바르지 않습니다. 4자 이상, 대소문자 포함, 숫자 및 특수문자(@$!%*?&#) 포함")
    private final String newPassword;

    public UpdateRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }


}
