package com.sparta.springindividual.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {
    private final Long id;
    private final String commentUserName;
    private final String commentDescription;
    private final LocalDateTime createAt;

    public CommentSaveResponseDto(Long id, String commentUserName, String commentDescription, LocalDateTime createdAt) {
        this.id = id;
        this.commentUserName = commentUserName;
        this.commentDescription = commentDescription;
        this.createAt = createdAt;
    }
}
