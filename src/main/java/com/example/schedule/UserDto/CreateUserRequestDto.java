package com.example.schedule.UserDto;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    //유저 생성 dto

    private final String username;
    private final String password;
    private final String email;

    public CreateUserRequestDto(String username,String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
