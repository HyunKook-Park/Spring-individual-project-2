package com.sparta.springindividual.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User extends TimeStamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false )
    private Long id;

    @Column(name="user_name", nullable = false )
    private String userName;

    @Column(name="user_email", nullable = false )
    private String userEmail;

    @OneToMany(mappedBy="user", orphanRemoval = true)
    private List<ScheduleManager> scheduleManagerList = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public void update(String userName) {
        this.userName = userName;
    }
}
