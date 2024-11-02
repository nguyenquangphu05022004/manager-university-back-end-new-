package com.example.manageruniversity.courses.creditClass.domain.entity;

import com.example.manageruniversity.core.location.Room;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "courses_time_table")
public class TimeTable extends SubBaseEntity {
    private LocalDateTime start;
    private LocalDateTime end;
    private Short dayOfWeek;
    private String room_name;
    @Enumerated(EnumType.STRING)
    private TimeType timeType;

    @ManyToOne
    @JoinColumn(name = "credit_class_id")
    private CreditClass creditClass;

    @ManyToOne
    @JoinColumn(name  = "room_id")
    private Room room;

    @RequiredArgsConstructor
    public enum TimeType {
        ON_SITE("Học trực tiếp"),
        REMOTE("Học trực tuyến"),
        PRACTICE("Thực hành");

        @Getter
        private final String value;
    }
}
