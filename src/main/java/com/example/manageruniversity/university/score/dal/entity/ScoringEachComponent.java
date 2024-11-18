package com.example.manageruniversity.university.score.dal.entity;

import com.example.manageruniversity.common.base.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "score_scoring_each_component")
@Entity
@Getter
@NoArgsConstructor
public class ScoringEachComponent extends SubBaseEntity {
   @Setter
    private Double value;

    @ManyToOne
    @JoinColumn(name = "score_id")
    private Score score;

    @ManyToOne
    @JoinColumn(name = "score_coefficient_id")
    private ScoreCoefficient scoreCoefficient;


    public ScoringEachComponent(Double value, Long score, Long scoreCoefficient) {
        this.value = value;
        this.score = new Score(score);
        this.scoreCoefficient = new ScoreCoefficient(scoreCoefficient);
    }
}
