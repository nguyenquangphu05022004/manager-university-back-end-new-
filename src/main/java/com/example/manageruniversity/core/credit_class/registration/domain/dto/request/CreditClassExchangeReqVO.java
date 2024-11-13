package com.example.manageruniversity.core.credit_class.registration.domain.dto.request;

import lombok.Data;

@Data
public class CreditClassExchangeReqVO {
    private Long fromStudentId;
    private Long creditClassIdRequest;
    private Long creditClassIdTarget;
    private Long toStudentId;
}
