package com.example.manageruniversity.university.tuition.dal.repo;

import com.example.manageruniversity.university.tuition.dal.dataobject.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
