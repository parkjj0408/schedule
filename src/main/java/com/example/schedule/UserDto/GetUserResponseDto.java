package com.example.schedule.UserDto;

import lombok.Getter;

@Getter
public class GetUserResponseDto {
    private final Long userid;
    private final String username;
    private final String email;

    public GetUserResponseDto(Long userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }
}