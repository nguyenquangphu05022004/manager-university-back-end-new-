package com.example.manageruniversity.core.tuition.dal.repo;

import com.example.manageruniversity.core.tuition.dal.dataobject.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
