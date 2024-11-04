package com.example.manageruniversity.core.auth;

import com.example.manageruniversity.common.pojo.CommonResult;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    @PermitAll
    public CommonResult<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return success(authService.authenticate(authRequest));
    }

    @PostMapping("/change-password")
    public CommonResult<?> changePassword(@RequestParam("oldPass") String oldPass,
                               @RequestParam("newPass") String newPass) {
        authService.changePassword(oldPass, newPass);
        return success(HttpStatus.OK.value(), "updated password success", null);
    }

    @PostMapping("/forgot-password")
    @PermitAll
    public CommonResult<?> forgotPassword(@RequestParam("email") String email) {
        authService.forgotPassword(email);
        return success(HttpStatus.OK.value(), "We hava sent code to your email, please check it", null);
    }
}
