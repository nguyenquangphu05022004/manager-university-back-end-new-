package com.example.manageruniversity.filter;

import com.example.manageruniversity.courses.credit_class_schedule.CreditClassRegistrationSchedule;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SchoolYearIdFilter extends FilterStrategy<CreditClassRegistrationSchedule> {
    @Override
    public Predicate filter() {
        return null;
    }
}
