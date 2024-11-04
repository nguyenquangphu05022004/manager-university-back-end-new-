package com.example.manageruniversity.core.tuition.dal.repository;

import com.example.manageruniversity.core.tuition.dal.model.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionRepository extends JpaRepository<Tuition, Long> {
}
