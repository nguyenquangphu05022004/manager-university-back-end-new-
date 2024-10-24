package com.example.manageruniversity.courses;

import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.cglib.core.Local;

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

}
