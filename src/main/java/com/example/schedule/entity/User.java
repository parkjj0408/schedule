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
   private  String username;
    @Column(nullable = false)
   private  String email;

   //기본 생성자
    public User(String username, String email){
        this.username = username;
        this.email = email;
    }


    public User() {

    }
}
