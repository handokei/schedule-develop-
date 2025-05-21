package com.example.schedule.service;


import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String planTitle, String planContents, String userName) {

        User findUser = userRepository.findUserByUserNameOrElseThrow(userName);

        Schedule schedule = new Schedule(planTitle, planContents);
        schedule.setnewUser(findUser);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule.getPlanId(),schedule.getPlanTitle(),schedule.getPlanContents());
    }

}
