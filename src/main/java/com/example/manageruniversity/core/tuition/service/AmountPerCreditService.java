package com.example.manageruniversity.core.tuition.service;

import com.example.manageruniversity.core.tuition.dal.model.request.AmountPerCreditRequest;
import com.example.manageruniversity.filter.Condition;

public interface AmountPerCreditService {
    void create(AmountPerCreditRequest request);
    void getAllByCondition(Condition condition);
}
