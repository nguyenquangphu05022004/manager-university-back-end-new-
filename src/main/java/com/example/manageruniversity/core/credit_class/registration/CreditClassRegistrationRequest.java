package com.example.manageruniversity.core.credit_class.registration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditClassRegistrationRequest {
    private String studentId;
    private Long creditClassId;
}
