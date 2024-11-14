package com.example.manageruniversity.core.tuition.service;

import com.example.manageruniversity.core.tuition.controller.vo.AmountPerCreditReqVO;
import com.example.manageruniversity.core.tuition.dal.entity.AmountPerCredit;
import com.example.manageruniversity.filter.Condition;

public interface AmountPerCreditService {
    AmountPerCredit create(AmountPerCreditReqVO request);
}
