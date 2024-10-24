package com.example.manageruniversity.repository;

import com.example.manageruniversity.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
