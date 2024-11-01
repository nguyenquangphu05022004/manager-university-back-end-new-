package com.example.manageruniversity.user.repo;

import com.example.manageruniversity.user.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
