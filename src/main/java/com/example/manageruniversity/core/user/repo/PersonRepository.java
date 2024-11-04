package com.example.manageruniversity.core.user.repo;

import com.example.manageruniversity.core.user.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
