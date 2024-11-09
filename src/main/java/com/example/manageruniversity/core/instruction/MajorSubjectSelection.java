package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.core.course.Course;
import com.example.manageruniversity.core.major.Major;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "core_major_selection")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MajorSubjectSelection extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;


    @ManyToMany
    @JoinTable(name = "major_selection_subject")
    private Set<Subject> subjects;

    private boolean status; //true: on else off;


}
