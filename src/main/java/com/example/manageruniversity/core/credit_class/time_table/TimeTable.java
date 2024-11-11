package com.example.manageruniversity.core.credit_class.time_table;

import com.example.manageruniversity.core.credit_class.self.CreditClass;
import com.example.manageruniversity.core.location.Room;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Entity
@Table(name = "courses_time_table")
@NoArgsConstructor
public class TimeTable extends SubBaseEntity {
    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;


    private Integer dayOfWeek;
    @Enumerated(EnumType.STRING)
    private TimeType timeType;

    @ManyToOne
    @JoinColumn(name = "credit_class_id")
    private CreditClass creditClass;

    @ManyToOne
    @JoinColumn(name  = "room_id")
    private Room room;

    public TimeTable(Long id,
                     LocalDate startDate, LocalDate endDate,
                     LocalTime startTime, LocalTime endTime,
                     Integer dayOfWeek,
                     TimeType timeType,
                     CreditClass creditClass,
                     Room room) {
        setId(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.timeType = timeType;
        this.creditClass = creditClass;
        this.room = room;
    }

    @RequiredArgsConstructor
    public enum TimeType {
        ON_SITE("Học trực tiếp"),
        REMOTE("Học trực tuyến"),
        PRACTICE("Thực hành");

        @Getter
        private final String value;
    }
}
