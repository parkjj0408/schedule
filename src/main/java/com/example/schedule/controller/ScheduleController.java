package com.example.schedule.controller;

import com.example.schedule.dto.CreateRequestDto;
import com.example.schedule.dto.CreateResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
//위에 어노테이션이 final 붙은 애들 찾아서 자동으로 생성자 만들어주는 애라서 public SceduleController(ScheduleService service) 이거 안해도 됨.
public class ScheduleController {
    //속성
    private final ScheduleService scheduleService;

    //일정 생성 단계 requestdto로 입력 받은걸 서비스로 전달
  @PostMapping("/save")
  public ResponseEntity<CreateResponseDto> save(@RequestBody CreateRequestDto requestDto){
      //전달받은 requestDto를 서비스에 넣어줘야 해서 하나씩 값을 꺼내줌
     CreateResponseDto createResponseDto = scheduleService.save(
             requestDto.getUsername(),
             requestDto.getTitle(),
             requestDto.getContents());
     // 그값을 리턴
      return new ResponseEntity<>(createResponseDto,HttpStatus.OK);
  }
//전체 조회 메서드
//@GetMapping
//    public ResponseEntity<List<>>

}
