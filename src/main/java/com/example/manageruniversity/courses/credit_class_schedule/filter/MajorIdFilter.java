package com.example.manageruniversity.courses.credit_class_schedule.filter;

import com.example.manageruniversity.common.filter.FilterStrategy;
import com.example.manageruniversity.courses.credit_class_schedule.CreditClassRegistrationSchedule;
import jakarta.persistence.criteria.Predicate;

public class MajorIdFilter extends FilterStrategy<CreditClassRegistrationSchedule> {
    @Override
    public Predicate filter() {
        return null;
    }
}
