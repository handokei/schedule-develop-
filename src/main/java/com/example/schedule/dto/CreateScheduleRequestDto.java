package com.example.schedule.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class CreateScheduleRequestDto {

    @NotNull
    @Range(min = 3, max = 200)
    private final String planTitle;
    @NotNull
    @Range(min = 10, max = 200)
    private final String planContents;
    @NotNull
    @Range(min = 2, max = 8)
    @Pattern(regexp = "^[가-힣]*$", message = "이름은 한글 2~8자여야 합니다.")
    private final String userName;

    public CreateScheduleRequestDto(String planTitle, String planContents, String userName) {
        this.planTitle = planTitle;
        this.planContents = planContents;
        this.userName = userName;
    }
}
