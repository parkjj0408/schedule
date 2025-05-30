package com.example.schedule.service;

import com.example.schedule.dto.CreateResponseDto;

import com.example.schedule.dto.GetScheduleResponseDto;
import com.example.schedule.dto.UpdateScheduleRequestDto;
import com.example.schedule.dto.UpdateScheduleResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ScheduleService {
    //속성
    private final ScheduleRepository scheduleRepository;
    //회원 ID도 가져와야 해서 의존성 속성으러 넣어줌
    private final UserRepository userRepository;

    //게시물 생성 로직
    public CreateResponseDto save(String username, String title, String contents) {
        User findUser = userRepository.findUserByUsernameOrElse(username);
        //위에 매개변수로 전달받은 걸로 스캐줄 만들어야 함 밑에 코드
        Schedule schedule = new Schedule(username, title, contents); // 그리고 일단 게시판 만들어주기
        schedule.setUser(findUser);
        //만든 게시물을 레파지토리에 넣어서 save로 만듬
        //그걸 다시  save 라는 객체로 만들어서 값을 get
        Schedule saved = scheduleRepository.save(schedule);
        return new CreateResponseDto(saved.getId(), saved.getUsername(), saved.getTitle(), saved.getContents(), saved.getCreateAt(), saved.getModifiedAt());
    }


    //단건 조회
    public GetScheduleResponseDto findScheduleById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        return new GetScheduleResponseDto(findSchedule.getId(), findSchedule.getUsername(), findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getCreateAt(), findSchedule.getModifiedAt());

    }

    //단 건 수정
    //수정 내용을 DBMS에 반영할려면 트랜직션 어노테이션 붙여야함
    @Transactional
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto updateScheduleRequestDto) {
        //레파지토리에서 해당 식별자에 스케줄을 찾는게 먼저 찾고 난 담에 수정
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        //값 꺼내서 입력받은 값으로 바꾸기.set ?
        if (updateScheduleRequestDto.getTitle() != null) {
            //널이 아니라면 입력받은 값으로 바꾸기
            findSchedule.setTitle(updateScheduleRequestDto.getTitle());
        }
        if (updateScheduleRequestDto.getContents() != null) {
            //널이 아니라면 입력받은 값으로 바꾸기
            findSchedule.setContents(updateScheduleRequestDto.getContents());
        }
        //넣고 다시 출려하기
        return new UpdateScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getCreateAt(), findSchedule.getModifiedAt());

    }

    //    //스케줄 삭제
    public void deleteSchedule(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
