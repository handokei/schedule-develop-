package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private final String userName;

    private final String password;

    private final String userEmail;

    public SignUpRequestDto(String userName, String password, String userEmail) {
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
    }
}
