package com.example.manageruniversity.filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
public abstract class FilterStrategy<T> {
    protected Root<T> root;
    protected CriteriaBuilder criteriaBuilder;
    protected String data;

    protected List<Pair<String, String>> joinAttributes;


    public FilterStrategy(Root<T> root,
                          CriteriaBuilder criteriaBuilder,
                          String data) {
        this.root = root;
        this.criteriaBuilder = criteriaBuilder;
        this.data = data;
    }
    public FilterStrategy(Root<T> root,
                          CriteriaBuilder criteriaBuilder,
                          String data,
                          List<Pair<String, String>> joinAttributes) {
        this(root, criteriaBuilder, data);
        this.joinAttributes = joinAttributes;
    }

    public void setData(String data) {
        this.data = data;
    }

    public abstract Predicate filter();


    @Getter
    @AllArgsConstructor
    public class Pair<K, V> {
        private String attribute;
        private String value;
    }
}
