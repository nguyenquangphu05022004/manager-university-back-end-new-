package com.example.manageruniversity.university.credit_class.registration_schedule;

import com.example.manageruniversity.university.course.Course;
import com.example.manageruniversity.university.major.Major;
import com.example.manageruniversity.university.school_year.SchoolYear;
import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@Entity
@Table(name = "courses_credit_class_registration_schedule")
@AllArgsConstructor
@NoArgsConstructor
public class CreditClassRegistrationSchedule extends SubBaseEntity {

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @Transient
    public boolean isOngoing() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(start) && now.isBefore(end);
    }

    @Transient
    public boolean isCompleted() {
        return end.isBefore(LocalDateTime.now());
    }

    @Transient
    public boolean isUpcoming() {
        return start.isAfter(LocalDateTime.now());
    }


}
