package com.example.schedule.dto;


import com.example.schedule.entity.User;
import lombok.Getter;

@Getter
public class UserListResponseDto {
    private final Long userId;

    private final String userName;

    private final String userEmail;

    public UserListResponseDto(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public static UserListResponseDto listDto(User user) {
        return new UserListResponseDto(user.getUserId(), user.getUserName(), user.getUserEmail());
    }
}
