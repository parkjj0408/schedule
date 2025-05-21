package com.example.schedule.service;

import com.example.schedule.UserDto.CreateUserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserResponseDto saveUser(String username, String email) {
        //위에 매개변수로 user객체 만들기
        User user = new User(username,email);
        User save = userRepository.save(user);
        return new CreateUserResponseDto(save.getUserId(),save.getUsername(), save.getEmail());
    }

    }

