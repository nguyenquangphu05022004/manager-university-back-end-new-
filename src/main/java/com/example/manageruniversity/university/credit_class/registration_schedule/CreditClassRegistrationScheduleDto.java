package com.example.manageruniversity.university.credit_class.registration_schedule;

import com.example.manageruniversity.university.course.CourseDto;
import com.example.manageruniversity.university.major.MajorDto;
import com.example.manageruniversity.university.school_year.SchoolYearDto;
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
