package service;


import dto.ScheduleResponseDto;
import entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ScheduleRepository;
import repository.UserRepository;

@Service
@RequiredArgsConstructor

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto save(String planTitle, String planContents, String planUserName) {
        Schedule schedule = new Schedule(planTitle, planContents);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule.getPlanId(),schedule.getPlanTitle(),schedule.getPlanContents());
    }

}
