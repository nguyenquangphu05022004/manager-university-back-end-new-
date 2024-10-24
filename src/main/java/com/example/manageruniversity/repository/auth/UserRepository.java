package com.example.manageruniversity.repository.auth;

import com.example.manageruniversity.domain.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

}
