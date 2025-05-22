package com.example.schedule.repository;

import com.example.schedule.UserDto.UpdateUserEmailRequestDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<User,Long> {
    //오류 로직 작성.
    //있으면 아이디로 유저를 찾고 아니면 오류메세지를 던져라
    default User findByIdOrElseThrow(Long userid) {
        return findById(userid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + userid));
    }
}


