package com.example.schedule.service;

import com.example.schedule.dto.CreateResponseDto;

import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    //속성
    private final ScheduleRepository scheduleRepository;

    //게시물 생성 로직
    public CreateResponseDto save(String username,String title,String contents){
        //위에 매개변수로 전달받은 걸로 스캐줄 만들어야 함 밑에 코드
        Schedule schedule = new Schedule(username,title,contents);
        //만든 게시물을 레파지토리에 넣어서 save로 만듬
        Schedule save= scheduleRepository.save(schedule);
        return new CreateResponseDto(save.getId(),save.getUsername(),save.getTitle(), save.getContents());
    }


//    }
}
