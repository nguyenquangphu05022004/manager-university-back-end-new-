package com.example.manageruniversity.score;

import com.example.manageruniversity.core.subject.Subject;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "score_sore_coefficient")
@Getter
public class ScoreCoefficient extends SubBaseEntity {
    private Double coefficient;
    private String score_type;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
