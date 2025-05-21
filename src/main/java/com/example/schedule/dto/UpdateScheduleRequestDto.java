package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    //게시글 수정 dto title, contents만 수정 가능

    private final String title;
    private final String contents;


    public UpdateScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
