package com.example.schedule.entity;

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
    //생성날은 한번 만들어지면 수정 되어지면 안도니까 펄스
    @Column(updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    //컬럼은 생략 가능 이름을 다르게 설정할때 사용 하거나
    //위에 생성날 처럼 설정 줄때
    private LocalDateTime modifiedAt;
}
