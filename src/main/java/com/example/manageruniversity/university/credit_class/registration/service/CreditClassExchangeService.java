package com.example.manageruniversity.university.credit_class.registration.service;

import com.example.manageruniversity.university.credit_class.registration.domain.dto.request.CreditClassExchangeReqVO;
import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassExchange;

import java.util.List;

public interface CreditClassExchangeService {
    CreditClassExchange sendRequest(CreditClassExchangeReqVO request);
    void processAccept(Long enId);
    void processDelete(Long enId);

    List<CreditClassExchange> getListByStudentIdAndCreditClassId(Long studentId, Long creditClassId);
}
