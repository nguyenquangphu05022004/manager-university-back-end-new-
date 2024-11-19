package com.example.manageruniversity.common.base;

import com.example.manageruniversity.security.utils.SecurityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditting {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            String loginUserUsername = SecurityUtils.getLoginUserUsername();
            if(loginUserUsername == null) return Optional.of(SecurityUtils.DEFAULT_USERNAME);
            return Optional.of(loginUserUsername);
        };
    }
}
