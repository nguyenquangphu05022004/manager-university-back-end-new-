package com.example.manageruniversity.score.domain.entity;

import com.example.manageruniversity.core.schoolYear.domain.entity.SchoolYear;
import com.example.manageruniversity.core.subject.domain.entity.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.domain.entity.Student;
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

}
