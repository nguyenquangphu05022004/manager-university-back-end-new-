package com.example.manageruniversity.user.domain.entity;

import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.major.domain.entity.Major;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "students")
@Getter
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
}
