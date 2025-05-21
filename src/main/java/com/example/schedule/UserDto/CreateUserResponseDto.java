package com.example.schedule.UserDto;

import lombok.Getter;

@Getter
public class CreateUserResponseDto {
    //유저 생성 응답 dto
    private final Long userId;
    private final String username;
    private final String email;

    public CreateUserResponseDto(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }
}
