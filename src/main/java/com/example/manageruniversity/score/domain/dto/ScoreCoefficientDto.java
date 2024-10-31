package com.example.manageruniversity.score.domain.dto;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.collection.MapUtils;
import com.example.manageruniversity.common.pojo.KeyPair;
import com.example.manageruniversity.core.subject.domain.dto.SubjectDto;
import com.example.manageruniversity.score.domain.entity.ScoreCoefficient;
import com.example.manageruniversity.score.domain.enums.ScoreType;
import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class ScoreCoefficientDto {
    private Long id;
    private Double coefficient;
    private int scoreTypeIndex;
    private SubjectDto subject;
    private Map<Integer, String> scoreTypes;

    public ScoreCoefficientDto(ScoreCoefficient scoreCoefficient) {
        if(scoreCoefficient == null) return;
        this.id = scoreCoefficient.getId();
        this.coefficient = scoreCoefficient.getCoefficient();
        this.scoreTypeIndex = scoreCoefficient.getScoreType().getIndex();
        this.subject = new SubjectDto(scoreCoefficient.getSubject());
        this.scoreTypes = MapUtils.convertToMap(
                ListUtils.toList(ScoreType.values())
                        .stream()
                        .map(type -> new KeyPair<>(type.getIndex(), type.getValue()))
                        .collect(Collectors.toSet())
        );
    }
}
