package com.example.manageruniversity.courses.credit_class_schedule;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreditClassRegistrationScheduleRequest {
    private Long schoolYearId;
    private String majorId;
    private String courseId;
    private LocalDateTime start;
    private LocalDateTime end;
}
