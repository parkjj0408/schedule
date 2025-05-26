package com.example.schedule.controller;

import com.example.schedule.UserDto.*;
import com.example.schedule.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    //속성, 생성자는 위에 어노테이션으로 생략가능
    private final UserService userService;

    //회원생성
    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto userResponseDto = userService.saveUser(createUserRequestDto.getUsername(), createUserRequestDto.getPassword(), createUserRequestDto.getEmail());
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

      // 로그인
//       @PostMapping("/login")
//       public ResponseEntity<String> login(@RequestBody  @Valid UserLoginRequestDto loginRequestDto, HttpServletRequest request) {
//           userService.login(loginRequestDto, request);
//           return ResponseEntity.ok("로그인되었습니다.");
//       }

       //id로 유저 찾기
    @GetMapping("/{userid}")
    public ResponseEntity<GetUserResponseDto> findUserById(@PathVariable Long userid) {
        GetUserResponseDto getUserResponseDto = userService.findUserById(userid);
        return new ResponseEntity<>(getUserResponseDto, HttpStatus.OK);
    }

    //이메일 수정
    @PatchMapping("/{userid}")
    public ResponseEntity<UpdateUserEmailResponseDto> updateEmail(
            @PathVariable Long userid,
            @RequestBody UpdateUserEmailRequestDto userEmailRequestDto) {
        UpdateUserEmailResponseDto updateUserEmailResponseDto = userService.updateEmail(userid, userEmailRequestDto);
        return new ResponseEntity<>(updateUserEmailResponseDto, HttpStatus.OK);
    }
       //유저 삭제
    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userid) {
        userService.deleteUser(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
