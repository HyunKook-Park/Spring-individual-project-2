package com.sparta.springindividual.dto;

import lombok.Getter;

@Getter
public class UserSimpleResponseDto {
    private final String userName;

    public UserSimpleResponseDto(String userName) {
        this.userName = userName;
    }
}
