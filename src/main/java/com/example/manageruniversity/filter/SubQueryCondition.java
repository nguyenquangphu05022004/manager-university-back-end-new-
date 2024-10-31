package com.example.manageruniversity.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubQueryCondition{
    private Class returnValue;
    private String attributeIsGotFromSubQueryResult;
    private Class fromClass; //what class for execute subquery
    private String attributeConditionForFilter;
    private String filterValue;

}
