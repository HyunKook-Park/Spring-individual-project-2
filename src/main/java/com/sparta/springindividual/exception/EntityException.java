package com.sparta.springindividual.exception;

import com.sparta.springindividual.entity.Comment;
import com.sparta.springindividual.entity.Schedule;
import com.sparta.springindividual.repository.CommentRepository;
import com.sparta.springindividual.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class EntityException {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 공통 예외 처리 메서드


    public Comment findCommentByIdOrThrow(Long commentUserId) {
        return commentRepository.findById(commentUserId).orElseThrow(()->new NoSuchElementException("Schedule not found"));
    }
}
