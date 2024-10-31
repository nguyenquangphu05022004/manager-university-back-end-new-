package com.example.manageruniversity.filter;

import lombok.Data;

import java.util.Map;

@Data
public class Condition {
    private Map<FilterType, Object> pair;
}
