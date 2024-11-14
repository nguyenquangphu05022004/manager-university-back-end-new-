package com.example.manageruniversity.web.security.config;


import com.example.manageruniversity.common.collection.CollUtils;
import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.web.security.JwtAuthenticationEntryPoint;
import com.example.manageruniversity.web.security.filter.JwtAuthenticationFilter;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private  final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtAuthEntryPoint;
    private final ApplicationContext applicationContext;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authenticationProvider(this.authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((customizer) -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> {
                    exception.authenticationEntryPoint(this.jwtAuthEntryPoint);
                })
                .authorizeHttpRequests(request -> {
                    request.anyRequest().permitAll();
//                   request.requestMatchers("/**").hasAnyRole("SUPER_ADMIN");
                });
        //Map<HttpMethod, Set<String>> urls = getAllUrls();
        return http.build();
    }

    private Map<HttpMethod, Set<String>> getAllUrls() {
        Map<HttpMethod, Set<String>> result = new HashMap<>();
        //get all request from controller
        RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping)
                applicationContext.getBean("requestMappingHandlerMapping");
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethodMap.entrySet()) {
            //duyet moi request controller
            HandlerMethod handlerMethod = entry.getValue();
            if (!handlerMethod.hasMethodAnnotation(PermitAll.class)) {
                /**
                 * Method cho phep xu ly truong hop khong can dang nhap cung co the
                 * su dung he thong
                 * Neu phuong thuc hien tai co annotation Permitall tuc la cho phep su dung ngay ca khi khong
                 * dang nhap
                 * Con nguoc lai muon truy cap vao url khac can dang nhap
                 * khi dang nhap se co cac quyen khac nhau
                 */
                continue;
            }
            Set<String> urls = new HashSet<>();
            if (entry.getKey().getPatternsCondition() != null) {
                urls.addAll(entry.getKey().getPatternsCondition().getPatterns());
            }
            //get all pattern of request
            if (entry.getKey().getPathPatternsCondition() != null) {
                urls.addAll(ListUtils.convertToList(entry.getKey().getPathPatternsCondition().getPatterns(), PathPattern::getPatternString));
            }
            if (urls.isEmpty()) {
                continue;
            }
            
            Set<RequestMethod> methods = entry.getKey().getMethodsCondition().getMethods();
            if (CollUtils.isEmpty(methods)) {
                putAll(result, HttpMethod.GET, urls);
                putAll(result, HttpMethod.POST, urls);
                putAll(result, HttpMethod.PUT, urls);
                putAll(result, HttpMethod.DELETE, urls);
                putAll(result, HttpMethod.HEAD, urls);
                putAll(result, HttpMethod.PATCH, urls);
                continue;
            }

            //them request vao result
            entry.getKey().getMethodsCondition().getMethods().forEach(requestMethod -> {
                switch (requestMethod) {
                    case GET:
                        putAll(result, HttpMethod.GET, urls);
                        break;
                    case POST:
                        putAll(result, HttpMethod.POST, urls);
                        break;
                    case PUT:
                        putAll(result, HttpMethod.PUT, urls);
                        break;
                    case DELETE:
                        putAll(result, HttpMethod.DELETE, urls);
                        break;
                    case HEAD:
                        putAll(result, HttpMethod.HEAD, urls);
                        break;
                    case PATCH:
                        putAll(result, HttpMethod.PATCH, urls);
                        break;
                }
            });
        }
        return result;
    }

    
    private void putAll(Map<HttpMethod, Set<String>> result, HttpMethod method, Set<String> urls) {
        if(result.containsKey(method)) {
            result.get(method).addAll(urls);
        } else {
            result.put(method, urls);
        }
    }

}
