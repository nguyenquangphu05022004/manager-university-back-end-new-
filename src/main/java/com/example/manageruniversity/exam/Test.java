package com.example.manageruniversity.exam;

import com.example.manageruniversity.core.location.Room;
import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.Student;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "exam_test")
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
}
