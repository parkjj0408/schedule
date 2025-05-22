package com.example.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private final LocalDateTime createAt;
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private final LocalDateTime modifiedAt;

    public UpdateScheduleResponseDto(Long id, String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
