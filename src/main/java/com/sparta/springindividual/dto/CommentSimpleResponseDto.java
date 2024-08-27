package com.sparta.springindividual.dto;

import com.sparta.springindividual.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSimpleResponseDto {
    private final Long id;
    private final String commentUserName;
    private final String commentDescription;
    private final LocalDateTime createdAt;

    public CommentSimpleResponseDto(Schedule schedule, String commentUserName, String commentDescription, LocalDateTime createdAt) {
        this.id = schedule.getId();
        this.commentUserName = commentUserName;
        this.commentDescription = commentDescription;
        this.createdAt = createdAt;
    }
}
