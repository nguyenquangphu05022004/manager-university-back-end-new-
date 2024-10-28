package com.example.manageruniversity.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public abstract class FilterStrategy<T> {
    protected Root<T> root;
    protected CriteriaBuilder criteriaBuilder;
    protected String data;

    public abstract Predicate filter();
}
