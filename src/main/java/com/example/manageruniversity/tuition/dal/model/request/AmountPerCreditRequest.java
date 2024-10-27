package com.example.manageruniversity.tuition.dal.model.request;

import lombok.Data;

@Data
public class AmountPerCreditRequest {
    private Integer amount;
    private Long schoolYearId;
    private String majorId;
    private String courseId;
}
