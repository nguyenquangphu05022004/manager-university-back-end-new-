package com.example.manageruniversity.core.credit_class.registration.service;

import com.example.manageruniversity.core.credit_class.registration.domain.dto.request.CreditClassExchangeRequest;
import com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassExchange;

import java.util.Collection;
import java.util.List;

public interface CreditClassExchangeService {
    CreditClassExchange sendRequest(CreditClassExchangeRequest request);
    void processAccept(Long enId);
    void processDelete(Long enId);

    List<CreditClassExchange> getListByStudentIdAndCreditClassId(String studentId, Long creditClassId);
}
