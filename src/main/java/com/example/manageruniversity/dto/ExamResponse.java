package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.TestType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExamResponse{
    private Long id;
    private String subjectName;
    private String roomClass;
    private TestType testType;
}
