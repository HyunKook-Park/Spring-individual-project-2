package com.sparta.springindividual.service;

import com.sparta.springindividual.dto.*;
import com.sparta.springindividual.entity.Schedule;
import com.sparta.springindividual.repository.CommentRepository;
import com.sparta.springindividual.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 요구사항 1단계 schedule 저장
    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getScheduleUserName(), requestDto.getTitle(), requestDto.getDescription());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleSaveResponseDto(savedSchedule.getId(), savedSchedule.getScheduleUsername(), savedSchedule.getTitle(), savedSchedule.getDescription(), savedSchedule.getCreatedAt());
    }

    // 요구사항 1단계 schedule 조회
    @Transactional(readOnly = true)
    public ScheduleDetailResponseDto getSchedule(Long id) {
        Schedule schedule = findScheduleByIdOrThrow(id);
        return new ScheduleDetailResponseDto(schedule.getId(), schedule.getTitle(), schedule.getDescription(), schedule.getCreatedAt());
    }

    // 요구사항 1단계 schedule 수정
    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = findScheduleByIdOrThrow(id);
        schedule.update(requestDto.getScheduleUserName(), requestDto.getTitle(), requestDto.getDescription());
        return new ScheduleUpdateResponseDto(schedule.getId(), schedule.getScheduleUsername(), schedule.getTitle(), schedule.getDescription(), schedule.getModifiedAt());
    }

    // 예외처리
    @Transactional(readOnly = true)
    public Schedule findScheduleByIdOrThrow(Long scheduleUserId) {
        return scheduleRepository.findById(scheduleUserId).orElseThrow(() -> new NoSuchElementException("Schedule not found"));
    }

    // 요구사항 3 단계 pageable
    @Transactional(readOnly = true)
    public Page<SchedulePageResponseDto> getSchedules(int page, int size, String sortBy, boolean isAsc) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Schedule> schedules = scheduleRepository.findAllByOrderByModifiedAtDesc(pageable);
        return schedules.map(schedule -> {
            Long commentCount = commentRepository.countByScheduleId(schedule.getId());
            return new SchedulePageResponseDto(
                    schedule.getTitle(),
                    schedule.getDescription(),
                    commentCount,
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt(),
                    schedule.getScheduleUsername()
            );
        });
    }

    // 요구사항 4 단계 삭제
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = findScheduleByIdOrThrow(id);
        scheduleRepository.delete(schedule);
    }
}
