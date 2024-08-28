package com.sparta.springindividual.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponseDto {
    private final String title;
    private final String description;
    private final Long commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    public SchedulePageResponseDto(String title, String description, Long commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title=title;
        this.description=description;
        this.commentCount=commentCount;
        this.createdAt=createdAt;
        this.modifiedAt=modifiedAt;
    }
}
