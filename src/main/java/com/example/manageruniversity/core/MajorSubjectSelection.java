package com.example.manageruniversity.core;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.schoolYear.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "core_major_subject_selection")
@Getter
public class MajorSubjectSelection extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
