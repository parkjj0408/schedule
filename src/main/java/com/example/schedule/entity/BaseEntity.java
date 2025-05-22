package com.example.schedule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    //생성날은 한번 만들어지면 수정 되어지면 안되니까 false
    @Column(updatable = false)
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private LocalDateTime createAt;


    @LastModifiedDate
//    @DateTimeFormat(pattern = "yy-MM-DD-hh-mm-ss")
    //컬럼은 생략 가능 이름을 다르게 설정할때 사용 하거나
    //위에 생성날 처럼 설정 줄때
    @JsonFormat(pattern = "yy-mm-dd hh:mm:ss")
    private LocalDateTime modifiedAt;
}
