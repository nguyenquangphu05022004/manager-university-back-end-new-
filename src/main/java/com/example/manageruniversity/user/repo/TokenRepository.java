package com.example.manageruniversity.user.repo;

import com.example.manageruniversity.user.domain.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {


    Optional<Token> findByToken(String token);
    Optional<Token> findByRefreshToken(String refreshToken);
    Optional<Token> findByUserUsernameAndRevoked(String username, boolean revoked);
    List<Token> findAllByUserUsername(String username);
}
