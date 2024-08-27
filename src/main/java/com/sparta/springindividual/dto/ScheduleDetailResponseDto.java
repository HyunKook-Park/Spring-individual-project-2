package com.sparta.springindividual.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ScheduleDetailResponseDto {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    private List<UserManagerDetailResponseDto> dtoList;


    public ScheduleDetailResponseDto(Long id, String title, String description, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createAt = createdAt;
    }

    public ScheduleDetailResponseDto(List<UserManagerDetailResponseDto> dtoList, Long id, String title, String description, LocalDateTime createdAt) {
        this.dtoList = dtoList;
        this.id = id;
        this.title = title;
        this.description = description;
        this.createAt = createdAt;
    }
}
