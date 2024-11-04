package com.example.manageruniversity.core.credit_class;

import lombok.Data;

@Data
public class CreditClassRequest {
    private int maxStudent;
    private String teacherId;
    private String subjectId;
    private Long schoolYearId;
    private int group;
}
