package com.example.manageruniversity.filter;

import com.example.manageruniversity.common.object.ObjectUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class Filter {
    public static  Specification filterAllCondition(Condition condition) {
        return filter(condition, "AND");
    };


    public static <T> Specification<T> filterAnyCondition(Condition condition) {
        return filter(condition, "OR");
    }

    private static Specification filter(Condition condition, String type) {
        return (root, query, criteriaBuilder) -> {
            Predicate  finalPredicate = null;
            for(var pair : condition.getPair().entrySet()) {
                Predicate predicate;
                if(pair.getValue() instanceof SubQueryCondition) {
                    SubQueryCondition subQueryCondition = (SubQueryCondition)pair.getValue();
                    var subQuery = query.subquery(subQueryCondition.getReturnValue());
                    var subRoot = query.from(subQueryCondition.getFromClass());
                    subQuery.select(subRoot
                                    .get(subQueryCondition.getAttributeIsGotFromSubQueryResult()))
                            .where(Filter.filter(condition, "AND").toPredicate(subRoot, query, criteriaBuilder));
                     predicate = criteriaBuilder.equal(root.get(pair.getKey().name()), subQuery);
                } else {
                    predicate = FilterFactory.getInstance(
                            pair.getKey(),
                            root,
                            criteriaBuilder,
                            (String) pair.getValue()
                    ).filter();
                }
                finalPredicate = ObjectUtils.isNull(finalPredicate) ? predicate :
                        (type.equals("AND") ? criteriaBuilder.and(finalPredicate, predicate) :
                                criteriaBuilder.or(finalPredicate, predicate));
            }
            return finalPredicate;
        };
    }

}
