package com.example.manageruniversity.system.auth.dal.repo;

import com.example.manageruniversity.system.auth.dal.dataobject.AuthRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface AuthRefreshTokenRepository extends JpaRepository<AuthRefreshToken, Long> {
    Optional<AuthRefreshToken> findByRefreshToken(String refreshToken);

    @Modifying
    void deleteByRefreshToken(String refreshToken);
}
