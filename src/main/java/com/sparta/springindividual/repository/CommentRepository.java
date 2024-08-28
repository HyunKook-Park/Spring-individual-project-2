package com.sparta.springindividual.repository;

import com.sparta.springindividual.entity.Comment;
import com.sparta.springindividual.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 외래키 가져오는 Query Method
    Long countByScheduleId(Long scheduleId);
    Comment findByScheduleAndId(Schedule schedule, Long commentId);
}
