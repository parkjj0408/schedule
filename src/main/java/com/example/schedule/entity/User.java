package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "user")

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;

   @Column(nullable = false)
    private String password;

    //기본 생성자
    public User() {
    };

//비밀번호 추가해서 로그인(유저생성)
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }

}
