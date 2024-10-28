package com.example.manageruniversity.score.domain.entity;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "score_scoring_each_component")
@Entity
@Getter
public class ScoringEachComponent extends SubBaseEntity {
    private Double value;

    @ManyToOne
    @JoinColumn(name = "score_id")
    private Score score;

    @ManyToOne
    @JoinColumn(name = "score_coefficient_id")
    private ScoreCoefficient scoreCoefficient;

}
