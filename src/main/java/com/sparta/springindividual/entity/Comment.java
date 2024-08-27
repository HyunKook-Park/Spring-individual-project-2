package com.sparta.springindividual.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "comments")
public class Comment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    @Column(name = "comment_username", nullable = false)
    private String commentUserName;
    @Column(name = "comment_description", nullable = false)
    private String commentDescription;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(Schedule schedule, String commentUserName, String commentDescription) {
        this.schedule = schedule;
        this.commentUserName = commentUserName;
        this.commentDescription = commentDescription;
    }

    public void update(String commentDescription) {
        this.commentDescription = commentDescription;
    }
}
