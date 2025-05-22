package com.example.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class GetScheduleResponseDto {
    //식별자로 게시물 조회dto
    private final Long id;
    private final String username;
    private final String title;
    private final String contents;
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private final LocalDateTime createAt;
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private final LocalDateTime modifiedAt;

    public GetScheduleResponseDto(Long id, String username, String title, String contents,LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
