package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.user.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_schedules")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestSchedule extends BaseEntity {
    private Integer testGroup;
    private Integer numberOfStudent;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @ManyToMany
    @JoinTable(name = "testSchedule_student",
            joinColumns = @JoinColumn(name = "testSchedule_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

}
