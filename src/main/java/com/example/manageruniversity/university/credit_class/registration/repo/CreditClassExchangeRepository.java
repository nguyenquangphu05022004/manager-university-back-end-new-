package com.example.manageruniversity.university.credit_class.registration.repo;

import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditClassExchangeRepository extends JpaRepository<com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassExchange, Long> {


    List<CreditClassExchange> findAllByToStudentIdAndTargetId(Long studentId, Long creditClassId);
}
