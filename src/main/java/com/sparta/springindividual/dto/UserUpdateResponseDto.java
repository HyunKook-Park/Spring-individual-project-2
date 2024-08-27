package com.sparta.springindividual.dto;

import lombok.Getter;

@Getter
public class UserUpdateResponseDto {
    private final String userName;

    public UserUpdateResponseDto(String userName) {
        this.userName = userName;
    }
}
