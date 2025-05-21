package com.example.schedule.service;

import com.example.schedule.dto.CreateResponseDto;

import com.example.schedule.dto.GetScheduleResponseDto;
import com.example.schedule.repository.ScheduleRepository;
import com.example.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
//public GetScheduleResponseDto find(){
//    List<Schedule> findAll = scheduleRepository.findAll();
//    //return
//
//}
    //스케줄 객체에 메모가 저장돼을 거니끼 여기서 찾아야 함.
    //찾아서 대조나 비즈니스 로직 하고 내보내야함.

//단건 조회
    public GetScheduleResponseDto findScheduleById(Long id){
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        return new GetScheduleResponseDto(findSchedule.getId(),findSchedule.getUsername(),findSchedule.getTitle(),findSchedule.getContents());

    }
    //단 건 수정
    //수정 내용을 DBMS에 반영할려면 트랜직션 어노테이션 붙여야함
    @Transactional
    public void updateSchedule(Long id, String title, String contents) {
        //해당 식별자에 스케줄을 찾는게 먼저 찾고 난 담에 수정
       Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
       //찾고 난 후에 타이틀과 컨텐츠를 수정해라 ..?
       findSchedule.setSchedule(title,contents);

    }
    //스케줄 삭제
    public void deleteSchedule(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
       scheduleRepository.delete(findSchedule);
    }
}
