package com.example.schedule.UserDto;

import lombok.Getter;

@Getter
public class UpdateUserEmailRequestDto {
    private final String email;

    public UpdateUserEmailRequestDto(String email) {
        this.email = email;
    }
}
