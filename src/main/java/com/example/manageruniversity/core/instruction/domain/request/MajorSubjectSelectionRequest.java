package com.example.manageruniversity.core.instruction.domain.request;

import lombok.Data;

@Data
public class MajorSubjectSelectionRequest {
    private String courseId;
    private Long schoolYearId;
    private String majorId;
    private String subjectId;
    private boolean status = false;
}
