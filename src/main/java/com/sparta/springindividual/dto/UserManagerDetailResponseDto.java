package com.sparta.springindividual.dto;

import lombok.Getter;

@Getter
public class UserManagerDetailResponseDto {
    private final Long id;
    private final String userName;
    private final String userEmail;

    public UserManagerDetailResponseDto(Long id, String userName, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
