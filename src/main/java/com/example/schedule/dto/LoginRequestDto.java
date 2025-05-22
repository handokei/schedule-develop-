package com.example.schedule.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private final String userEmail;

    @NotNull
    private final String password;
}
