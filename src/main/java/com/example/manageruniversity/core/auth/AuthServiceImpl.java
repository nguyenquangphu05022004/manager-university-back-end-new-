package com.example.manageruniversity.core.auth;

import com.example.manageruniversity.common.collection.CollectionUtils;
import com.example.manageruniversity.common.exception.PasswordNotMatchException;
import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.security.SecurityUtils;
import com.example.manageruniversity.mq.producer.EmailProducer;
import com.example.manageruniversity.web.security.JwtService;
import com.example.manageruniversity.core.user.domain.entity.Token;
import com.example.manageruniversity.core.user.domain.entity.User;
import com.example.manageruniversity.core.user.domain.enums.TokenType;
import com.example.manageruniversity.core.user.repo.TokenRepository;
import com.example.manageruniversity.core.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailProducer emailProducer;
    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        User user = userRepository.findUserByUsernameIgnoreCase(authRequest.getUsername()).get();
        String jwtToken = this.jwtService.generateToken(user);
        String jwtRefreshToken = this.jwtService.generateRefreshToken(user);
        Token token = new Token(
                jwtToken,
                jwtRefreshToken,
                false,
                TokenType.BEARER,
                user
        );
        /**
         * Revoked all token previous
         */
        List<Token> tokens = this.tokenRepository.findAllByUserUsername(user.getUsername());
        if(CollectionUtils.isEmpty(tokens)) {
            tokens.forEach(s -> {
                s.setRevoked(true);
                this.tokenRepository.save(s);
            });
        }
        /**
         * Store token
         */
        this.tokenRepository.save(token);

        AuthResponse authResponse = new AuthResponse(
                jwtToken,
                jwtRefreshToken,
                null,
                null
        );
        return authResponse;
    }

    @Override
    public void forgotPassword(String email) {
        User user = this.userRepository.findUserByEmailIgnoreCase(email)
                .orElseThrow(() -> new ResourcesNotFoundException("Email not found"));
        this.emailProducer.publish(
                "Forget password",
                "Your code: " + "random",
                user.getUsername(),
                user.getEmail()
        );
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        User user = SecurityUtils.getLoginUser();
        if(this.passwordEncoder.matches(oldPass, user.getPassword())) {
            user.setPassword(this.passwordEncoder.encode(newPass));
            this.userRepository.save(user);
            return;
        }
        throw new PasswordNotMatchException("Your old password not match");
    }

}
