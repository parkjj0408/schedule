package com.example.schedule.dto;

import lombok.Getter;

@Getter

public class GetScheduleResponseDto {
    //게시물 조회
    private final Long id;
    private final String username;
    private final String title;
    private final String contents;

    public GetScheduleResponseDto(Long id, String username, String title, String contents) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
