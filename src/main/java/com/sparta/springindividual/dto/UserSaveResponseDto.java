package com.sparta.springindividual.dto;

import lombok.Getter;

@Getter
public class UserSaveResponseDto {
    private final String userName;

    public UserSaveResponseDto(String userName) {
        this.userName = userName;
    }
}
