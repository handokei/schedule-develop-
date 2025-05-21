package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long planId;

    private final String planTitle;

    private final String planContents;

    public ScheduleResponseDto(Long planId, String planTitle, String planContents) {
        this.planId = planId;
        this.planTitle = planTitle;
        this.planContents = planContents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getPlanId(), schedule.getPlanTitle(), schedule.getPlanContents());
    }
}
