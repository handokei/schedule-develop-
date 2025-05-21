package com.example.schedule.controller;


import com.example.schedule.dto.CreateScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.schedule.service.ScheduleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(requestDto.getPlanTitle(), requestDto.getPlanContents(), requestDto.getUserName());
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.CREATED);

    }

    //전체조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList,HttpStatus.OK);
    }

    //단건조회
    @GetMapping("/{userId}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long userId) {
       ScheduleResponseDto scheduleResponseDto = scheduleService.findById(userId);

       return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK);
    }
}
