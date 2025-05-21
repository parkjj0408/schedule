package com.example.schedule.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CreateRequestDto {
    //할 일 생성 할때 밑에 내용을 입력받음
    private final String username;
    private final String title;
    private final String contents;


    public CreateRequestDto(String username,String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}


