package com.example.manageruniversity.auth;

import com.example.manageruniversity.common.pojo.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.manageruniversity.common.pojo.CommonResult.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public CommonResult<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return success(authService.authenticate(authRequest));
    }
    @GetMapping("/logout")
    public void logout() {
        authService.logout();
    }


    @PostMapping("/change-password")
    public void changePassword(@RequestParam("oldPass") String oldPass,
                               @RequestParam("newPass") String newPass) {
        authService.changePassword(oldPass, newPass);
    }
}
