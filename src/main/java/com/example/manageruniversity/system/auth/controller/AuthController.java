package com.example.manageruniversity.system.auth.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.string.StringUtils;
import com.example.manageruniversity.system.auth.controller.vo.AuthLoginReqVO;
import com.example.manageruniversity.system.auth.controller.vo.AuthLoginResVO;
import com.example.manageruniversity.system.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.security.PermitAll;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Table(name = "Authentication")
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @PermitAll
    @Operation(summary = "login app")
    public CommonResult<AuthLoginResVO> login(@RequestBody AuthLoginReqVO reqVO) {
        return CommonResult.success(authService.login(reqVO));
    }

    @GetMapping("/logout")
    @PermitAll
    @Operation(summary = "logout app")
    public CommonResult<Boolean> logout(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization").substring(7);
        if(!StringUtils.isEmpty(accessToken)) {
            this.authService.logout(accessToken);
        }
        return CommonResult.success(true);
    }

    @PostMapping("/refresh-token")
    @PermitAll
    @Operation(summary = "refresh token")
    @Parameter(name = "refreshToken", required = true, description = "Lam moi accessToken khi het han")
    public CommonResult<AuthLoginResVO> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return CommonResult.success(this.authService.refreshToken(refreshToken));
    }

}
