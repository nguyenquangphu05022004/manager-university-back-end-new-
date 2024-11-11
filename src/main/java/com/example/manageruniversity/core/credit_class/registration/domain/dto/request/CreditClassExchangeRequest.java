package com.example.manageruniversity.core.credit_class.registration.domain.dto.request;

import lombok.Data;

@Data
public class CreditClassExchangeRequest {
    private String fromStudentId;
    private Long creditClassIdRequest;
    private Long creditClassIdTarget;
    private String toStudentId;
}
