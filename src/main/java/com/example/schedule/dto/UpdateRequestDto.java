package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class UpdateRequestDto {

    private final String oldPassword;

    private final String newPassword;

    public UpdateRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }


}
