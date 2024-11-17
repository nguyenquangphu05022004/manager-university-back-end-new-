package com.example.manageruniversity.system.auth.dal.repo;

import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface AuthAccessTokenRepository extends JpaRepository<AuthAccessToken, Long> {
    List<AuthAccessToken> findAllByRefreshToken(String refreshToken);

    @Modifying
    void deleteAllByRefreshToken(String refreshToken);

    AuthAccessToken findByAccessToken(String accessToken);
}
