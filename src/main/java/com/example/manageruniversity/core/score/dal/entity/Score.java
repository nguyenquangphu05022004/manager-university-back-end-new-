package com.example.manageruniversity.core.score.dal.entity;

import com.example.manageruniversity.core.member.dal.entities.Student;
import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "score_scores")
@NoArgsConstructor
@Getter
public class Score extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_Id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;

    @OneToMany(mappedBy = "score")
    private List<ScoringEachComponent> scoringEachComponents;

    public Score(Student student, Subject subject, SchoolYear schoolYear) {
        this.student = student;
        this.subject = subject;
        this.schoolYear = schoolYear;
    }
}
