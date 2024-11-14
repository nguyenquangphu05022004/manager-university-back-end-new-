package com.example.manageruniversity.core.score.dal.entity;

import com.example.manageruniversity.core.school_year.SchoolYear;
import com.example.manageruniversity.core.score.dal.enums.ScoreType;
import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "score_sore_coefficient")
@Getter
@Setter
@NoArgsConstructor
public class ScoreCoefficient extends SubBaseEntity {

    private Double coefficient;
    @Enumerated(EnumType.STRING)
    private ScoreType scoreType;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "school_year_id")
    private SchoolYear schoolYear;


    public ScoreCoefficient(Double coefficient,
                            ScoreType scoreType,
                            String subjectId,
                            Long schoolYearId) {
        this.coefficient = coefficient;
        this.scoreType = scoreType;
        this.subject = new Subject(subjectId);
        this.schoolYear = new SchoolYear(schoolYearId);
    }
    public ScoreCoefficient(Long id) {
        setId(id);
    }
}
