package com.example.manageruniversity.core.exam;

import com.example.manageruniversity.core.location.Room;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.domain.entity.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "exam_test")
@Getter
@NoArgsConstructor
public class Test extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private LocalDate startDate;
    private LocalTime startTime;
    private int inMinutes;

    private String format;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

    @ManyToMany
    @JoinTable(name = "exam_candidate_in_test",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;


    public Test(Subject subject, Room room, LocalDate startDate,
                LocalTime startTime, int inMinutes,
                String format, SchoolYear schoolYear,
                Set<Student> students) {
        this.subject = subject;
        this.room = room;
        this.startDate = startDate;
        this.startTime = startTime;
        this.inMinutes = inMinutes;
        this.format = format;
        this.schoolYear = schoolYear;
        this.students = students;
    }
}
