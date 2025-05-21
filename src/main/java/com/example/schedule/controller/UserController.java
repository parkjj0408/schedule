package com.example.schedule.controller;

import com.example.schedule.UserDto.CreateUserRequestDto;
import com.example.schedule.UserDto.CreateUserResponseDto;
import com.example.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    //속성, 생성자는 위에 어노테이션으로 생략가능
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser (@RequestBody CreateUserRequestDto createUserRequestDto){
           CreateUserResponseDto userResponseDto = userService.saveUser(createUserRequestDto.getUsername(),createUserRequestDto.getEmail());
          return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
