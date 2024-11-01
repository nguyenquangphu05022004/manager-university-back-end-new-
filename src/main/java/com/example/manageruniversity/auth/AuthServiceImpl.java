package com.example.manageruniversity.auth;

import com.example.manageruniversity.common.collection.CollectionUtils;
import com.example.manageruniversity.common.exception.PasswordNotMatchException;
import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.security.SecurityUtils;
import com.example.manageruniversity.service.auth.JwtService;
import com.example.manageruniversity.user.domain.entity.Token;
import com.example.manageruniversity.user.domain.entity.User;
import com.example.manageruniversity.user.domain.enums.Role;
import com.example.manageruniversity.user.domain.enums.TokenType;
import com.example.manageruniversity.user.repo.TokenRepository;
import com.example.manageruniversity.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
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
        //send mail
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        User user = SecurityUtils.getLoginUser();
        if(this.passwordEncoder.matches(oldPass, user.getPassword())) {
            user.setPassword(this.passwordEncoder.encode(newPass));
            this.userRepository.save(user);
            //response api
        }
        throw new PasswordNotMatchException("Your old password not match");
    }

    @Override
    public void changeRoleUser(String username, Role role) {
        User user = this.userRepository.findUserByUsernameIgnoreCase(username)
                .orElseThrow(() -> new ResourcesNotFoundException("Username not found"));
        user.setRole(role);
        this.userRepository.save(user);
        //response

    }

    @Override
    public void lockIfLoginFailedExceededPermission() {

    }

    @Override
    public void logout() {
        User userLogin = SecurityUtils.getLoginUser();
        Optional<Token> optionalToken = this.tokenRepository.findByUserUsernameAndRevoked(
                userLogin.getUsername(),
                false
        );
        if(optionalToken.isPresent()) {
            optionalToken.get().setRevoked(true);
            this.tokenRepository.save(optionalToken.get());
        }
        //ok
    }
}
