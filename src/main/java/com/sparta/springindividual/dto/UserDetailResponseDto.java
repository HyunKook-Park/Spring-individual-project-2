package com.sparta.springindividual.dto;

import lombok.Getter;

@Getter
public class UserDetailResponseDto {
    private final String userName;

    public UserDetailResponseDto(String userName) {
        this.userName = userName;
    }
}
