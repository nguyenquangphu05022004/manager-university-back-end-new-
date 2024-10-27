package com.example.manageruniversity.tuition.service;

import com.example.manageruniversity.common.filter.Condition;
import com.example.manageruniversity.tuition.dal.model.request.AmountPerCreditRequest;

public interface AmountPerCreditService {
    void create(AmountPerCreditRequest request);
    void getAllByCondition(Condition condition);
}
