package com.example.manageruniversity.university.instruction;

import lombok.Data;

import java.util.Set;

@Data
public class MajorSubjectSelectionRequest {
    private String courseId;
    private Long schoolYearId;
    private String majorId;
    private Set<String> subjectIds;
    private boolean status = false;
}
