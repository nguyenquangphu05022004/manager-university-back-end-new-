package com.example.manageruniversity.dto;

import com.example.manageruniversity.domain.TestType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamRequest {
    private Long seasonId;
    private Long classRoomId;
    private Long subjectId;
    private TestType testType;
}
