package com.example.schedule.repository;


import com.example.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    default User findByIdOrElseThrow(Long userid) {
        return findById(userid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + userid));
    }
    // 게시판 생성할때 옵셔널로 널 안나오게 찾으러감
    Optional<User> findUserByUsername(String username);
    // 유저네임으로 유저를 찾는 메서드 만약 없으면 오류를 던져라
   default User findUserByUsernameOrElse(String username) {
       return findUserByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
   }
}






//
//     // 우선 유저 객체에 username으로 있는지 없는지부터 확인 널일지 아닐지 모르니까 옵셔널로 감쌈

//
//    //오류 로직 작성.
//    //있으면 아이디로 유저를 찾고 아니면 오류메세지를 던져라
//    default User findUserByIdOrElseThrow(Long userid) {
//        return findById(userid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + userid));
//    }
//
//   // User findByIdOrElseThrow(Long userid);



