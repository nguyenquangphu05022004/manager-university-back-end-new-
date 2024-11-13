package com.example.manageruniversity.core.auth;

import com.example.manageruniversity.common.collection.CollUtils;
import com.example.manageruniversity.common.exception.PasswordNotMatchException;
import com.example.manageruniversity.core.auth.token.Token;
import com.example.manageruniversity.core.auth.token.TokenRepository;
import com.example.manageruniversity.core.auth.token.TokenType;
import com.example.manageruniversity.core.member.dal.entities.User;
import com.example.manageruniversity.core.member.dal.repo.UserRepository;
import com.example.manageruniversity.core.member.service.UserService;
import com.example.manageruniversity.web.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserService userService;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        User user = userService.getByUsername(authRequest.getUsername());
        if(!userService.passwordMatch(authRequest.getPassword(), user.getPassword())) {
            throw new PasswordNotMatchException("password not match");
        }
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
        if(CollUtils.isEmpty(tokens)) {
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
                jwtService.extractExpiration(jwtToken).getTime(),
                user.getFullName()
        );
        return authResponse;
    }

    @Override
    public void logout() {

    }

    @Override
    public void refreshToken() {

    }


}
