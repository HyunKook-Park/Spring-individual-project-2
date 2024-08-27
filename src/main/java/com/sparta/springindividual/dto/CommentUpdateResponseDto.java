package com.sparta.springindividual.dto;

import com.sparta.springindividual.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateResponseDto {
    private final Long id;
    private final String commentUserName;
    private final String commentDescription;
    private final LocalDateTime modifiedAt;

    public CommentUpdateResponseDto(Schedule schedule, String commentUserName, String commentDescription, LocalDateTime modifiedAt) {
        this.id = schedule.getId();
        this.commentUserName = commentUserName;
        this.commentDescription = commentDescription;
        this.modifiedAt = modifiedAt;
    }
}
