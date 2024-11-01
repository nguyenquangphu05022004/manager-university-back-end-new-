package com.example.manageruniversity.user.repo;

import com.example.manageruniversity.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUsernameIgnoreCase(String username);
    Optional<User> findUserByEmailIgnoreCase(String email);
}
