package com.example.manageruniversity.courses.credit_class_schedule;

import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.Now;

import java.time.LocalDate;
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
