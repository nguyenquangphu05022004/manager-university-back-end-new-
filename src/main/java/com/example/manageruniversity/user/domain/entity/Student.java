package com.example.manageruniversity.user.domain.entity;

import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.user.domain.request.StudentRequest;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "students")
@Getter
@DiscriminatorValue("STUDENT")
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

}
