package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String userName;

    private final String userEmail;


    public UserResponseDto(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
