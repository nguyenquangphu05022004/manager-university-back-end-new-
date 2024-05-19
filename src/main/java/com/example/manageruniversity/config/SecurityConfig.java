package com.example.manageruniversity.config;


import com.example.manageruniversity.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
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
            "/api/v1/mail/**"
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
            "/api/v1/grades/**"
    };
    private static final String[] LIST_URL_ACCESS_BY_TEACHER = {
            "/api/v1/grades/**"
    };
    private  final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtAuthEntryPoint;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req-> {
                    req.requestMatchers(WHITE_LIST_URL)
                            .permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/v1/file/**").permitAll()
                            .requestMatchers(HttpMethod.POST, LIST_URL_ACCESS_BY_ADMIN).hasAuthority(Role.ADMIN.name())
                            .requestMatchers(LIST_URL_ACCESS_BY_TEACHER).hasAuthority(Role.STUDENT.name())
                            .anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .exceptionHandling(except -> {
                    except.authenticationEntryPoint(jwtAuthEntryPoint);
                })
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
