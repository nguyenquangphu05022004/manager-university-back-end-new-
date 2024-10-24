package com.example.manageruniversity.courses;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
}
