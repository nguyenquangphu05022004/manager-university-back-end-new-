package com.example.manageruniversity.score.domain.entity;

import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.score.domain.enums.ScoreType;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "score_sore_coefficient")
@Getter
public class ScoreCoefficient extends SubBaseEntity {
    private Double coefficient;
    @Enumerated(EnumType.STRING)
    private ScoreType scoreType;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
