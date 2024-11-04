package com.example.manageruniversity.core.credit_class.registration_schedule;

import com.example.manageruniversity.core.course.CourseDto;
import com.example.manageruniversity.core.major.MajorDto;
import com.example.manageruniversity.core.school_year.SchoolYearDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreditClassRegistrationScheduleDto {
    private Long id;
    private SchoolYearDto schoolYear;
    private MajorDto major;
    private LocalDateTime start;
    private LocalDateTime end;
    private CourseDto course;

    private boolean ongoing;
    private boolean isCompleted;
    private boolean isUpcoming;

    public CreditClassRegistrationScheduleDto(CreditClassRegistrationSchedule schedule) {
        this.schoolYear = new SchoolYearDto(schedule.getSchoolYear());
        this.major = new MajorDto(schedule.getMajor());
        this.start = schedule.getStart();
        this.end = schedule.getEnd();
        this.course = new CourseDto(schedule.getCourse());
        this.id = schedule.getId();
        this.ongoing = schedule.isOngoing();
        this.isUpcoming = schedule.isUpcoming();
        this.isCompleted = schedule.isCompleted();
    }
}
