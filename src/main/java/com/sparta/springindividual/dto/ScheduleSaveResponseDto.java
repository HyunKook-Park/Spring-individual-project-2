package com.sparta.springindividual.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleSaveResponseDto {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ScheduleSaveResponseDto(Long id, String title, String description, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createAt = createdAt;
    }
}
