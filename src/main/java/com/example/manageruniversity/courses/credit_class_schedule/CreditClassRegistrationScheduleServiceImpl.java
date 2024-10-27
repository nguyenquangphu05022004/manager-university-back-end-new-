package com.example.manageruniversity.courses.credit_class_schedule;

import com.example.manageruniversity.common.filter.Condition;
import com.example.manageruniversity.common.filter.FilterFactory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class CreditClassRegistrationScheduleServiceImpl
        implements CreditClassRegistrationScheduleService {
    @Override
    public void create(CreditClassRegistrationScheduleRequest request) {

    }

    @Override
    public void update(Long creditClassRegistrationScheduleId,
                       CreditClassRegistrationScheduleRequest request) {

    }

    @Override
    public void getAllByCondition(Condition condition) {
        Specification<CreditClassRegistrationSchedule> specification =
                ((root, query, criteriaBuilder) -> {
                    Predicate predicate = null;
                    for(var s : condition.getPair().entrySet()) {
                        Predicate filter = FilterFactory
                                .getInstance(s.getKey())
                                .filter();
                        predicate = (predicate == null) ? filter : criteriaBuilder.and(predicate);
                    }
                    return predicate;
                });
    }
}
