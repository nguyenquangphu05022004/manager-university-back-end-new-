package com.example.manageruniversity.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.format.DateTimeFormatter;
import java.util.Random;

public class SystemUtils {
    public static final DateTimeFormatter PATTERN_DATE_VIE = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    public static final int NUMBER_OF_MINUTE_EXPIRE_FORGET_CODE = 5;
    public static final String ANONYMOUS = "ANONYMOUS";
    public static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }
    public static String getCode() {
        String str = "0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            stringBuilder.append(str.charAt(random.nextInt(9)));
        }
        return stringBuilder.toString();
    }
}
