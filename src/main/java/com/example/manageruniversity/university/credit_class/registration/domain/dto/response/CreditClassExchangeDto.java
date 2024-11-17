package com.example.manageruniversity.university.credit_class.registration.domain.dto.response;

import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassExchange;
import com.example.manageruniversity.university.credit_class.self.CreditClassDto;
import com.example.manageruniversity.university.member.domain.dto.response.StudentDto;

public class CreditClassExchangeDto {
    private StudentDto fromStudent;
    private CreditClassDto request;
    private CreditClassDto target;

    public CreditClassExchangeDto(CreditClassExchange creditClassExchange) {
        this.fromStudent = new StudentDto(creditClassExchange.getFromStudent());
        this.request =new CreditClassDto(creditClassExchange.getRequest());
        this.target = new CreditClassDto(creditClassExchange.getTarget());
    }
}
