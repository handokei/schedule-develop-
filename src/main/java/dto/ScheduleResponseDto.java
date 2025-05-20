package dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long planid;

    private final String planTitle;

    private final String planContents;




    public ScheduleResponseDto(Long planid, String planTitle, String planContents) {
        this.planid = planid;
        this.planTitle = planTitle;
        this.planContents = planContents;
    }
}
