package com.sparta.springindividual.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "schedule")
public class Schedule extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    // ScheduleManger 1:N
    @OneToMany(mappedBy = "schedule", orphanRemoval = true)
    private List<ScheduleManager> scheduleManagerList = new ArrayList<>();

    // User N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void update(String scheduleUserName, String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void delete(Comment comment) {
        commentList.remove(comment);
    }
}
