package dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {
    private final Long userId;
    private final String userName;
    private final String userEmail;

    public SignUpResponseDto(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
