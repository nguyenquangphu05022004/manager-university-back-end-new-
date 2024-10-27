package com.example.manageruniversity.courses.credit_class_schedule;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Entity
@Table(name = "courses_credit_class_registration_schedule")
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
        return false;
    }

    @Transient
    public boolean isCompleted() {
        return false;
    }

    @Transient
    public boolean isUpcoming() {
        return false;
    }


}
