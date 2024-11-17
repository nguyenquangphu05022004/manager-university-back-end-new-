package com.example.manageruniversity.university.tuition.controller.vo;

import lombok.Data;

@Data
public class AmountPerCreditReqVO {
    private Integer amount;
    private Long schoolYearId;
    private String majorId;
    private String courseId;
}
