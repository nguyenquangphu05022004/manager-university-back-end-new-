package com.example.manageruniversity.courses.credit_class_schedule;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreditClassRegistrationScheduleDto {

    private Long schoolYearId;

    private String majorId;
    private LocalDateTime start;
    private LocalDateTime end;

    private String courseId;

}
