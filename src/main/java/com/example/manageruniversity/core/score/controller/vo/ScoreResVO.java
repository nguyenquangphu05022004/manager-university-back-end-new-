package com.example.manageruniversity.core.score.controller.vo;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.core.score.dal.entity.Score;
import com.example.manageruniversity.core.subject.SubjectDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Data
@Schema(name = "Score - Thong tin diem cua mon hoc")
public class ScoreResVO {
    @Schema(description = "Thong tin ve mon hoc")
    private SubjectDto subject;

    @Schema(description = "Danh sach cac diem thanh phan cua mon hoc")
    private List<ScoringEachComponentResVO> scoringEachComponents;


    public ScoreResVO(Score score) {
        this.subject = new SubjectDto(score.getSubject());
        this.scoringEachComponents = ListUtils.convertToList(score.getScoringEachComponents(),  ScoringEachComponentResVO::new);
    }
}
