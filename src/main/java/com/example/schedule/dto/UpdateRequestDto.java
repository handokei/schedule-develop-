package com.example.schedule.dto;


import lombok.Getter;

@Getter
public class UpdateRequestDto {


    private final String oldPasswqrd;

    private final String newPassword;

    public UpdateRequestDto(String oldPasswqrd, String newPassword) {
        this.oldPasswqrd = oldPasswqrd;
        this.newPassword = newPassword;
    }


}
