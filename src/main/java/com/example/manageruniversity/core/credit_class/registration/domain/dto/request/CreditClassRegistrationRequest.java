package com.example.manageruniversity.core.credit_class.registration.domain.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditClassRegistrationRequest {
    private String studentId;
    private Long creditClassId;
    private Long schoolYearId;
}
