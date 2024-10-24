package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "times")
@Data
@Getter
public class Time extends BaseEntity {
    // 0 -> sunday 1-> monday
    private Integer dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "subject_group_id")
    private SubjectGroup subjectGroup;
    @ManyToOne
    @JoinColumn(name = "room_class_id")
    private RoomClass roomClass;
}
