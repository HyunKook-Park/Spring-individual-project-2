package com.sparta.springindividual.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="schedulemanager")
public class ScheduleManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
