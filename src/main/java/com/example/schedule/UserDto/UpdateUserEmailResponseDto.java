package com.example.schedule.UserDto;

import lombok.Getter;

@Getter
public class UpdateUserEmailResponseDto {
    private final Long userid;
    private final String username;
    private final String email;


    public UpdateUserEmailResponseDto(Long userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }
}
