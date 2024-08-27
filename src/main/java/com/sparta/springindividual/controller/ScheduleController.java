package com.sparta.springindividual.controller;

import com.sparta.springindividual.dto.*;
import com.sparta.springindividual.service.CommentService;
import com.sparta.springindividual.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final CommentService commentService;

    // 일정 저장
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> saveSchedule(@RequestBody ScheduleSaveRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.saveSchedule(requestDto));
    }

    // 요구사항 3 pageable
    @GetMapping("/schedules")
    public Page<SchedulePageResponseDto> getSchedules(@RequestParam int page, @RequestParam(defaultValue = "10") int size, @RequestParam String sortBy, @RequestParam boolean isAsc) {
        return scheduleService.getSchedules(page - 1, size, sortBy, isAsc);
    }

    // 일정 단건 조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleDetailResponseDto> getSchedule(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getSchedule(id));
    }

    // 일정 수정
    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleUpdateResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, requestDto));
    }

    // 요구사항 4 일정 삭제
    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }

    // 요구사항 2 comment 저장
    @PostMapping("/schedules/{id}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long id, @RequestBody CommentSaveRequestDto requestDto) {
        return ResponseEntity.ok(commentService.saveComment(id, requestDto));
    }

    // 요구사항 2 comment 단건 조회
    @GetMapping("schedules/{id}/comments/{commentId}")
    public ResponseEntity<CommentSimpleResponseDto> getComment(@PathVariable Long id, @PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.getComment(id, commentId));
    }

    // 요구사항 2 comment 다건 조회
    @GetMapping("schedules/{id}/comments")
    public ResponseEntity<List<CommentDetailResponseDto>> getAllComments(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getAllComments(id));
    }

    // 요구사항 2 comment 수정
    @PutMapping("schedules/{id}/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(@PathVariable Long id, @PathVariable Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
        return ResponseEntity.ok(commentService.updateComment(id, commentId, requestDto));
    }

    // 요구사항 2 comment 삭제
    @DeleteMapping("schedules/{id}/comments/{commentId}")
    public void deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
        commentService.deleteComment(id, commentId);
    }
}
