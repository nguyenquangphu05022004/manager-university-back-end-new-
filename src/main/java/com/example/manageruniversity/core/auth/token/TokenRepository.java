package com.example.manageruniversity.core.auth.token;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {


    Optional<Token> findByToken(String token);
    Optional<Token> findByRefreshToken(String refreshToken);
    Optional<Token> findByUserUsernameAndRevoked(String username, boolean revoked);
    List<Token> findAllByUserUsername(String username);
}
