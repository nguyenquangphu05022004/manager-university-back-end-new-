package com.example.manageruniversity.common.security;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.member.dal.entities.User;
import com.example.manageruniversity.core.member.domain.enums.MemberType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(ObjectUtils.isNull(authentication) || authentication instanceof AnonymousAuthenticationToken ) {
            return null;
        }
        return (User) authentication.getPrincipal();
    }

    public static Long userIdLogin() {
        User user = getLoginUser();
        if(ObjectUtils.isNull(user)) {
            return null;
        }
        return user.getId();
    }

    public static MemberType getMemberType() {
        User user = getLoginUser();
        if(ObjectUtils.isNull(user)) {
            return null;
        }
        return user.getMemberType();
    }




}
