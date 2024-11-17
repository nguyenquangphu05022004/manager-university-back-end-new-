package com.example.manageruniversity.system.auth.service;

import com.example.manageruniversity.common.collection.CollUtils;
import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;
import com.example.manageruniversity.system.auth.dal.dataobject.AuthRefreshToken;
import com.example.manageruniversity.system.auth.dal.redis.config.RedisAccessTokenDao;
import com.example.manageruniversity.system.auth.dal.repo.AuthAccessTokenRepository;
import com.example.manageruniversity.system.auth.dal.repo.AuthRefreshTokenRepository;
import com.example.manageruniversity.web.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.manageruniversity.common.exception.yu.utils.ServiceExceptionUtils.*;
import static com.example.manageruniversity.system.auth.enums.ErrorCodeConstants.*;

@Service
@RequiredArgsConstructor
public class AuthTokenServiceImpl implements AuthTokenService {

    private final JwtService jwtService;
    private final RedisAccessTokenDao redisAccessTokenDao;
    private final AuthAccessTokenRepository authAccessTokenRepository;
    private final AuthRefreshTokenRepository authRefreshTokenRepository;

    @Override
    public AuthAccessToken createAccessToken(Long userid) {
        AuthRefreshToken authRefreshToken = createAuthRefreshToken(userid);
        return createAccessToken(userid, authRefreshToken);
    }

    private AuthAccessToken createAccessToken(Long userid, AuthRefreshToken authRefreshToken) {
        AuthAccessToken authAccessToken = new AuthAccessToken(
                authRefreshToken.getUser(),
                jwtService.generateToken(String.valueOf(userid)),
                authRefreshToken.getRefreshToken()
        );
        this.authAccessTokenRepository.save(authAccessToken);
        return authAccessToken;
    }

    private AuthRefreshToken createAuthRefreshToken(Long userid) {
        AuthRefreshToken authRefreshToken = new AuthRefreshToken(userid, jwtService.generateRefreshToken(String.valueOf(userid)));
        authRefreshTokenRepository.save(authRefreshToken);
        return authRefreshToken;
    }

    @Override
    public AuthAccessToken refreshAccessToken(String refreshToken) {
        AuthRefreshToken authRefreshToken = this.authRefreshTokenRepository
                .findByRefreshToken(refreshToken)
                .orElseThrow(() -> exception(REFRESH_TOKEN_NOT_FOUND));

        List<AuthAccessToken> accessTokens = this.authAccessTokenRepository.findAllByRefreshToken(refreshToken);
        if(!CollUtils.isEmpty(accessTokens)) {
           authAccessTokenRepository.deleteAllByRefreshToken(refreshToken);
           redisAccessTokenDao.delete(ListUtils.convertToList(accessTokens, AuthAccessToken::getAccessToken));
        }

        if(jwtService.isTokenExpired(refreshToken)) {
            this.authRefreshTokenRepository.deleteByRefreshToken(refreshToken);
            throw exception(ACCESS_TOKEN_IS_EXPIRED);
        }

        return createAccessToken(authRefreshToken.getUser().getId(), authRefreshToken);
    }

    @Override
    public AuthAccessToken getAccessToken(String accessToken) {
        AuthAccessToken authAccessToken = redisAccessTokenDao.get(accessToken);
        if(authAccessToken != null) {
            return authAccessToken;
        }

        authAccessToken = this.authAccessTokenRepository.findByAccessToken(accessToken);

        if(authAccessToken != null && !jwtService.isTokenExpired(authAccessToken.getAccessToken())) {
            this.redisAccessTokenDao.setToken(authAccessToken);
        }
        return authAccessToken;
    }

    @Override
    public AuthAccessToken checkAccessToken(String accessToken) {
        AuthAccessToken authAccessToken = getAccessToken(accessToken);
        if(ObjectUtils.isNull(authAccessToken)) {
            throw exception(ACCESS_TOKEN_NOT_FOUND);
        }
        return authAccessToken;
    }

    @Override
    public AuthAccessToken removeAccessToken(String accessToken) {
        AuthAccessToken authAccessToken = this.authAccessTokenRepository.findByAccessToken(accessToken);
        if(ObjectUtils.isNull(authAccessToken)) {
            return null;
        }
        this.authAccessTokenRepository.deleteById(authAccessToken.getId());
        this.redisAccessTokenDao.delete(accessToken);
        this.authRefreshTokenRepository.deleteByRefreshToken(authAccessToken.getRefreshToken());
        return authAccessToken;
    }
}
