package com.sparta.springindividual.service;

import com.sparta.springindividual.dto.*;
import com.sparta.springindividual.entity.Comment;
import com.sparta.springindividual.entity.Schedule;
import com.sparta.springindividual.exception.EntityException;
import com.sparta.springindividual.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleService scheduleService;

    // 요구사항 2단계 comment 저장
    @Transactional
    public CommentSaveResponseDto saveComment(Long id, CommentSaveRequestDto requestDto) {
        Schedule schedule = scheduleService.findScheduleByIdOrThrow(id);
        Comment comment = new Comment(schedule, requestDto.getCommentUserName(), requestDto.getCommentDescription());
        Comment savedComment = commentRepository.save(comment);
        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getCommentUserName(), savedComment.getCommentDescription(), savedComment.getCreatedAt());
    }

    // 요구사항 2단계 comment 단건조회
    @Transactional(readOnly = true)
    public CommentSimpleResponseDto getComment(Long scheduleId, Long id) {
        Schedule schedule = scheduleService.findScheduleByIdOrThrow(scheduleId);
        Comment comment = commentRepository.findByScheduleAndCommentId(schedule, id);
        return new CommentSimpleResponseDto(comment.getSchedule(), comment.getCommentUserName(), comment.getCommentDescription(), comment.getCreatedAt());
    }

    // 요구사항 2단계 comment 다건조회
    public List<CommentDetailResponseDto> getAllComments(Long id) {
        Schedule schedule = scheduleService.findScheduleByIdOrThrow(id);
        List<Comment> savedComment = schedule.getCommentList();
        List<CommentDetailResponseDto> commentDto = new ArrayList<>();
        for (Comment comment : savedComment) {
            CommentDetailResponseDto commentDetailDto = new CommentDetailResponseDto(comment.getSchedule(), comment.getCommentUserName(), comment.getCommentDescription(), comment.getCreatedAt());
            commentDto.add(commentDetailDto);
        }
        return commentDto;
    }

    // 요구사항 2단계 comment 수정
    @Transactional
    public CommentUpdateResponseDto updateComment(Long id, Long commentId, CommentUpdateRequestDto requestDto) {
        Schedule schedule = scheduleService.findScheduleByIdOrThrow(id);
        Comment comment = commentRepository.findByScheduleAndCommentId(schedule, commentId);
        comment.update(requestDto.getCommentDescription());
        return new CommentUpdateResponseDto(comment.getSchedule(), comment.getCommentUserName(), comment.getCommentDescription(), comment.getModifiedAt());
    }

    // 요구사항 2단계 comment 삭제
    @Transactional
    public void deleteComment(Long id, Long commentId) {
        Schedule schedule = scheduleService.findScheduleByIdOrThrow(id);
        Comment comment = schedule.getCommentList().stream().filter(c -> c.getId().equals(commentId)).findFirst().orElseThrow();
        schedule.delete(comment);
    }

    public Comment findCommentByIdOrThrow(Long commentUserId) {
        return commentRepository.findById(commentUserId).orElseThrow(() -> new NoSuchElementException("Schedule not found"));

    }
}
