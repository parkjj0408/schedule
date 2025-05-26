package com.example.schedule.UserDto;

import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
public class UserLoginRequestDto {
    //로그인 dto 얘랑 유저 생성자 비교 ?

    private final String email;
    private final String password;


    public UserLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
