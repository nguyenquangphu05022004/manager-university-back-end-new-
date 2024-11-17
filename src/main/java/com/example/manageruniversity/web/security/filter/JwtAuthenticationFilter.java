package com.example.manageruniversity.web.security.filter;

import com.example.manageruniversity.common.string.StringUtils;
import com.example.manageruniversity.system.auth.dal.dataobject.AuthAccessToken;
import com.example.manageruniversity.system.auth.service.AuthTokenService;
import com.example.manageruniversity.web.security.LoginUser;
import com.example.manageruniversity.web.security.utils.SecurityUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthTokenService authTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = SecurityUtils.obtainToken(request);
        if(!StringUtils.isEmpty(token)) {
            LoginUser loginUser = buildLoginUser(token);
            if(loginUser != null) {
                SecurityUtils.setLoginUser(loginUser, request);
            }
        }
        filterChain.doFilter(request, response);
    }

    private LoginUser buildLoginUser(String token) {
        try {
            AuthAccessToken authAccessToken = this.authTokenService.getAccessToken(token);
            LoginUser loginUser = new LoginUser(
                    authAccessToken.getUser().getId(),
                    authAccessToken.getUser().getUsername(),
                    authAccessToken.getExpires()
            );
            return loginUser;
        } catch (Exception e) {
            return null;
        }
    }
}
