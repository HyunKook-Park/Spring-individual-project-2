package com.sparta.springindividual.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleUpdateResponseDto {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime modifiedAt;

    public ScheduleUpdateResponseDto(Long id, String title, String description, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modifiedAt = modifiedAt;
    }
}
