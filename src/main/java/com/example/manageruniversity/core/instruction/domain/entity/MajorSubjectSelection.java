package com.example.manageruniversity.core.instruction.domain.entity;

import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import com.example.manageruniversity.core.subject.domain.entity.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "core_major_subject_selection")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MajorSubjectSelection extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;
    private boolean status; //true: on else off;


}
