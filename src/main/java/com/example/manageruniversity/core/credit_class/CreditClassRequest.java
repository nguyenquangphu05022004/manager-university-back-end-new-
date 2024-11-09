package com.example.manageruniversity.core.credit_class;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditClassRequest {
    private Integer maxStudent;
    private String teacherId;
    private String subjectId;
    private Long schoolYearId;
    private Integer group;
}
