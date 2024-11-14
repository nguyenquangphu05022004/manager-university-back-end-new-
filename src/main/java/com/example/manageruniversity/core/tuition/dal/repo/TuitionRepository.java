package com.example.manageruniversity.core.tuition.dal.repo;

import com.example.manageruniversity.core.tuition.dal.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionRepository extends JpaRepository<Tuition, Long> {
}
