package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public UpdateScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
