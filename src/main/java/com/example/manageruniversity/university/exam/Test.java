package com.example.manageruniversity.university.exam;

import com.example.manageruniversity.university.location.Room;
import com.example.manageruniversity.university.member.dal.entities.Student;
import com.example.manageruniversity.university.school_year.SchoolYear;
import com.example.manageruniversity.university.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
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


    public Test(String subject, LocalDate startDate,
                LocalTime startTime, int inMinutes,
                String format, Long schoolYear,
                Set<Student> students) {
        this.subject = new Subject(subject);
        this.startDate = startDate;
        this.startTime = startTime;
        this.inMinutes = inMinutes;
        this.format = format;
        this.schoolYear = new SchoolYear(schoolYear);
        this.students = students;
    }
}
