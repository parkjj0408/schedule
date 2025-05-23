package com.example.schedule.service;

import com.example.schedule.UserDto.CreateUserResponseDto;
import com.example.schedule.UserDto.GetUserResponseDto;
import com.example.schedule.UserDto.UpdateUserEmailRequestDto;
import com.example.schedule.UserDto.UpdateUserEmailResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserResponseDto saveUser(String username,String password, String email) {
        //위에 매개변수로 user객체 만들기
        User user = new User(username, password, email);
        User save = userRepository.save(user);
        return new CreateUserResponseDto(save.getUserid(), save.getUsername(), save.getEmail());
    }
    //아이디로 회원 조회
    public GetUserResponseDto findUserById(Long userid) {
        User findUser = userRepository.findByIdOrElseThrow(userid);
        return new GetUserResponseDto(findUser.getUserid(), findUser.getUsername(), findUser.getEmail());
    }


    //수정
    @Transactional
    public UpdateUserEmailResponseDto updateEmail(Long userid, UpdateUserEmailRequestDto updateUserEmailRequestDto) {
        User updateEmail = userRepository.findByIdOrElseThrow(userid);

        if (updateUserEmailRequestDto.getEmail() != null) {
            updateEmail.setEmail(updateUserEmailRequestDto.getEmail());
        }
        return new UpdateUserEmailResponseDto(updateEmail.getUserid(), updateEmail.getUsername(), updateEmail.getEmail());
    }

    //삭제
    public void deleteUser(Long userid) {
        User findUser = userRepository.findByIdOrElseThrow(userid);
        userRepository.delete(findUser);
    }
}

