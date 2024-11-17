package com.example.manageruniversity.system.auth.service;

import com.example.manageruniversity.system.auth.controller.vo.AuthLoginReqVO;
import com.example.manageruniversity.system.auth.controller.vo.AuthLoginResVO;
import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;
import com.example.manageruniversity.university.member.dal.entities.User;
import com.example.manageruniversity.university.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.manageruniversity.common.exception.yu.utils.ServiceExceptionUtils.*;
import static com.example.manageruniversity.system.auth.enums.ErrorCodeConstants.PASSWORD_NOT_FOUND;
import static com.example.manageruniversity.system.auth.enums.ErrorCodeConstants.USERNAME_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthTokenService authTokenService;
    private final UserService userService;
    @Override
    public AuthLoginResVO login(AuthLoginReqVO reqVO) {
        User user = this.userService.getByUsername(reqVO.getUsername());
        if(user == null) {
            throw exception(USERNAME_NOT_FOUND);
        }

        if(!this.userService.isPasswordMatch(reqVO.getPassword(), user.getPassword())) {
            throw exception(PASSWORD_NOT_FOUND);
        }

        return createTokenAfterLoginSuccess(user);
    }

    private AuthLoginResVO createTokenAfterLoginSuccess(User user) {
        AuthAccessToken authAccessToken = this.authTokenService.createAccessToken(user.getId());
        authAccessToken.setUser(user);
        return new AuthLoginResVO(authAccessToken);
    }

    @Override
    public void logout(String accessToken) {
        this.authTokenService.removeAccessToken(accessToken);
    }

    @Override
    public AuthLoginResVO refreshToken(String refreshToken) {
        AuthAccessToken authAccessToken = this.authTokenService.refreshAccessToken(refreshToken);
        return new AuthLoginResVO(authAccessToken);
    }
}
