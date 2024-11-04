package com.example.manageruniversity.core.instruction;

import lombok.Data;

@Data
public class MajorSubjectSelectionRequest {
    private String courseId;
    private Long schoolYearId;
    private String majorId;
    private String subjectId;
    private boolean status = false;
}
