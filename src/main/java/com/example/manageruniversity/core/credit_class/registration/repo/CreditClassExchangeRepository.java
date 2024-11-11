package com.example.manageruniversity.core.credit_class.registration.repo;

import com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditClassExchangeRepository extends JpaRepository<com.example.manageruniversity.core.credit_class.registration.domain.entities.CreditClassExchange, Long> {

    @Query("select c from CreditClassExchange c \n" +
            "where c.target.id = :creditClassId and c.toStudent.personId = :studentId")
    List<CreditClassExchange> findAllByTargetCreditClassAndToStudent(Long creditClassId, String studentId);
}
