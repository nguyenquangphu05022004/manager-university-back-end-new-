package com.example.manageruniversity.university.score.controller.vo;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.university.score.dal.entity.Score;
import com.example.manageruniversity.university.subject.SubjectDto;
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

    private Double average;
    private String letter;


    public ScoreResVO(Score score) {
        this.subject = new SubjectDto(score.getSubject());
        this.scoringEachComponents = ListUtils.convertToList(score.getScoringEachComponents(), ScoringEachComponentResVO::new);
        this.average = this.scoringEachComponents.stream()
                .mapToDouble(s -> s.getValue())
                .average()
                .getAsDouble();
        this.letter = extractToLetter(this.average);
    }

    private String extractToLetter(Double average) {
        if(average >= 9) return "A+";
        else if(average >= 8.5) return "A";
        else if(average >= 8.0) return "B+";
        else if(average >= 7.0) return "B";
        else if(average >= 6.5) return "C+";
        else if(average >= 5.5) return "C";
        else if(average >= 5.0) return "D+";
        else if(average >= 4.0) return "D";
        return "E";
    }
}
