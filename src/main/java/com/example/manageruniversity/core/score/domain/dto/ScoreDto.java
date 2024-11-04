package com.example.manageruniversity.core.score.domain.dto;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.score.domain.entity.Score;
import com.example.manageruniversity.core.subject.SubjectDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ScoreDto {
    private Long id;
    private SubjectDto subject;
    private SchoolYearDto schoolYearDto;
    private List<ScoringEachComponentDto> scoringEachComponents;

    public ScoreDto(Score score) {
        if(ObjectUtils.isNull(score)) return;
        this.id = score.getId();
        this.subject = ObjectUtils.init(SubjectDto.class, score.getSubject());
        this.schoolYearDto = ObjectUtils.init(SchoolYearDto.class, score.getSchoolYear());
        this.scoringEachComponents = ListUtils.convert(
                ScoringEachComponentDto.class,
                score.getScoringEachComponents());
    }
}
