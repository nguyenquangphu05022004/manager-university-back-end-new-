package com.example.manageruniversity.web.security.config;


import com.example.manageruniversity.user.domain.enums.Role;
import com.example.manageruniversity.web.security.JwtAuthenticationEntryPoint;
import com.example.manageruniversity.web.security.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private static final String[] WHITE_LIST_URL={
            "/api/v1/auth/**",
            "/api/v1/notifications/**",
            "/api/v1/export/**",
            "/vnpay-payment",
            "/api/v1/mail/**",
            "/api/v1/aspirations/**",
    };
    private static final String[] LIST_URL_ACCESS_BY_STUDENT = {
            "/api/v1/seasons/**",
            "/api/v1/testSchedules/**",
            "/api/v1/file/**",
            "/api/v1/subjects/**",
            "/api/v1/subjectGroups/**",
            "/api/v1/majorRegister/**"
    };
    private static final String[] LIST_URL_ACCESS_BY_ADMIN = {
            "/api/v1/courses/**",
            "/api/v1/students/**",
            "/api/v1/teachers/**",
            "/api/v1/subjects/**",
            "/api/v1/times/**",
            "/api/v1/testSchedules/**",
            "/api/v1/subjectGroups/**",
            "/api/v1/seasons/**",
            "/api/v1/roomClasses/**",
            "/api/v1/majors/**",
            "/api/v1/majorRegister/**",
            "/api/v1/grades/**",
    };
    private static final String[] LIST_URL_ACCESS_BY_TEACHER = {
            "/api/v1/grades/**"
    };
    private  final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtAuthEntryPoint;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .sessionManagement((customizer) -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
