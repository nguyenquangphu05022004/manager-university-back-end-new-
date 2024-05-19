package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.sendMail.EmailRequest;

public interface IEmailSenderService {
    void sender(EmailRequest emailRequest);
}
