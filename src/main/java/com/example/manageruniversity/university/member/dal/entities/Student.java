package com.example.manageruniversity.university.member.dal.entities;

import com.example.manageruniversity.university.course.Course;
import com.example.manageruniversity.university.credit_class.self.CreditClass;
import com.example.manageruniversity.university.major.Major;
import com.example.manageruniversity.university.member.domain.enums.MemberType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@DiscriminatorValue("STUDENT")
@NoArgsConstructor
public class Student extends User {
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToMany(mappedBy = "students")
    private Set<CreditClass> creditClasses;

    public Student(Long studentId) {
        super(studentId);
    }

    public Student(String username, String password, MemberType memberType, String email, String fullName, String address, String phoneNumber, Date dateOfBirth, Boolean sex) {
        super(username, password, memberType, email, fullName, address, phoneNumber, dateOfBirth, sex);
    }
}
