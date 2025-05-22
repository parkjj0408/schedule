package com.example.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter

public class CreateResponseDto {
    //게시물 생성 응답 dto
    //작성자명 , 제목, 내용, 생성일, 수정일
   // private final String title;
    private final Long id;
    private final String username;
    private final String title;
    private final String contents;
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private final LocalDateTime createAt;
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private final LocalDateTime modifiedAt;

    public CreateResponseDto(Long id, String username, String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }
}
