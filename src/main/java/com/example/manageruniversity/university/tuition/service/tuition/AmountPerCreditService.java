package com.example.manageruniversity.university.tuition.service.tuition;

import com.example.manageruniversity.university.tuition.controller.vo.AmountPerCreditReqVO;
import com.example.manageruniversity.university.tuition.dal.dataobject.AmountPerCredit;

import java.util.List;

public interface AmountPerCreditService {
    void create(AmountPerCreditReqVO request);
    void update(Long id, AmountPerCreditReqVO reqVO);
    void delete(Long id);
    List<AmountPerCredit> getList();
}
