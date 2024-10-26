package com.example.manageruniversity.courses.creditClass;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "courses_credit_class")
@Getter
public class CreditClass extends SubBaseEntity {
    private Short maxStudent;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

    private Integer group;
}
