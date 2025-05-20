package dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String planTitle;

    private final String planContents;

    private final String userName;

    public ScheduleRequestDto(String planTitle, String planContents, String userName) {
        this.planTitle = planTitle;
        this.planContents = planContents;
        this.userName = userName;
    }
}
