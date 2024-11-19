package com.example.manageruniversity.security.utils;

import com.example.manageruniversity.security.LoginUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.Collections;

public class SecurityUtils {


    public static final String HEADER = "Authorization";
    public static final String TYPE_TOKEN = "Bearer ";
    public static final String DEFAULT_USERNAME = "Anonymous";

    public static String obtainToken(HttpServletRequest request) {
        String header = request.getHeader(HEADER);
        if(header == null) return null;
        if(!header.startsWith(TYPE_TOKEN)) return null;
        return header.substring(7);
    }

    public static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return null;
        }
        return authentication;
    }

    public static String getLoginUserUsername() {
        LoginUser loginUser = getLoginUser();
        return (loginUser != null) ? loginUser.getUsername() : null;
    }

    public static LoginUser getLoginUser() {
        Authentication authentication = getAuthentication();
        if(authentication == null) {
            return null;
        }
        return (authentication instanceof LoginUser) ? (LoginUser) authentication : null;
    }

    public static Long getLoginUserId() {
        LoginUser loginUser = getLoginUser();
        return loginUser != null ? loginUser.getUserId() : null;
    }


    public static void setLoginUser(LoginUser loginUser, HttpServletRequest request) {
        Authentication authentication = setAuthentication(loginUser, request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private static Authentication setAuthentication(LoginUser loginUser, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginUser, null, Collections.emptyList()
        );
        authenticationToken.setDetails(new WebAuthenticationDetails(request));
        return authenticationToken;
    }
}
