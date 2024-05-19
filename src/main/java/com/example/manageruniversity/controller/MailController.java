package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.sendMail.EmailRequest;
import com.example.manageruniversity.service.IEmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MailController {
    private final IEmailSenderService emailSenderService;

    @PostMapping("/api/v1/mail/forget-password")
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        emailRequest.setSubject("Lấy lại mật khẩu tài khoản");
        emailSenderService.sender(emailRequest);
    }
}
