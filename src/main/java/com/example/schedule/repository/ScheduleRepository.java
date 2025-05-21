package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface  ScheduleRepository extends JpaRepository<Schedule, Long>{
    //여기에 findaAll 메서드를정의하지 않는 이유는 저 jpaRepasitory에 기본적으로 작성이되어ㅣㅇㅆ기 때문
    //근데 그걸 땡겨서 쓰니까 뭐가 변하지 않는 이상 안해도 됨.

// default를 사용한 이유 인터페이스에서 메서드를 정의해서 쓰기 위해선 이거사용해야함.
    //id 값을 입력받아서 할일을 찾는데  없으면 밑에 오류를 내보냄

//    default 키워드를 사용해서 Repository 인터페이스 안에 메서드를 구현하면,
//    원래 있는 메서드를 커스터마이징(확장)하거나 새로운 기능을 추가하는 것
    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

    }
