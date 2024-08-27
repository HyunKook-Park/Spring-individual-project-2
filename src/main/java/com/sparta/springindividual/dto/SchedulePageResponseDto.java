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
    private final String scheduleUserName;

    public SchedulePageResponseDto(String title, String description, Long commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt, String scheduleUserName) {
        this.title = title;
        this.description = description;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.scheduleUserName = scheduleUserName;
    }
}
