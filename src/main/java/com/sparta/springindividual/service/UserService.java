package com.sparta.springindividual.service;


import com.sparta.springindividual.dto.*;
import com.sparta.springindividual.entity.User;
import com.sparta.springindividual.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto requestDto){
        User user = new User(requestDto.getUserName());
        User saveUser = userRepository.save(user);
        return new UserSaveResponseDto(saveUser.getUserName());
    }

    public List<UserSimpleResponseDto> getAllUsers(){
        List<User> userList = userRepository.findAll();
        List<UserSimpleResponseDto> dtoList = new ArrayList<>();
        for (User user : userList) {
            UserSimpleResponseDto dto = new UserSimpleResponseDto(user.getUserName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public UserDetailResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
        return new UserDetailResponseDto(user.getUserName());
    }

    @Transactional
    public UserUpdateResponseDto updateUser(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
        user.update(requestDto.getUserName());
        return new UserUpdateResponseDto(user.getUserName());
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found"));
        userRepository.delete(user);
    }


}

