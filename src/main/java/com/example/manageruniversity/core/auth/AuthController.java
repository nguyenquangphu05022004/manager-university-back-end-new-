package com.example.manageruniversity.core.auth;

import com.example.manageruniversity.common.pojo.CommonResult;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    @PermitAll
    public CommonResult<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return success(authService.authenticate(authRequest));
    }

    @PostMapping("/logout")
    public CommonResult<?> logout() {
        return null;
    }

    @PostMapping("/refresh-token")
    public CommonResult<AuthResponse> refreshToken() {
        return null;
    }

}
