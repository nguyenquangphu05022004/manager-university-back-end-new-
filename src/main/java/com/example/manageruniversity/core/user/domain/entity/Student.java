package com.example.manageruniversity.core.user.domain.entity;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Getter
@DiscriminatorValue("STUDENT")
@NoArgsConstructor
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    public Student(String studentId) {
        super(studentId);
    }

}
