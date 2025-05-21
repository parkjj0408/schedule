package com.example.schedule.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")

public class Schedule extends BaseEntity {
    //기본키 설정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     //작성 유저명
    @Column(nullable = false)
    private String username;
    //제목
    @Column(nullable = false)
    private String title;
    //내용
    @Column(nullable = false)
    private String contents;
//엔티티 어노테이션에는 기본생성자 필수임
 public Schedule(){}
    //게시글 생성 생성자
    public Schedule(String username,String title,String contents){
                this.username =username;
        this.title = title;
        this.contents = contents;
    }
}
