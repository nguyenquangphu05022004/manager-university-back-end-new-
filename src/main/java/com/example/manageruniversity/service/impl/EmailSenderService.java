package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.sendMail.EmailRequest;
import com.example.manageruniversity.dto.sendMail.EmailSender;
import com.example.manageruniversity.entity.auth.ForgetCode;
import com.example.manageruniversity.entity.auth.User;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.repository.auth.ForgetCodeRepository;
import com.example.manageruniversity.repository.auth.UserRepository;
import com.example.manageruniversity.service.IEmailSenderService;
import com.example.manageruniversity.utils.SystemUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmailSenderService implements IEmailSenderService {
    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;
    @Value("${spring.mail.username}")
    private String emailSender;
    @Value("${url.front.end.getPassword}")
    private String urlFrontEnd;
    private final ForgetCodeRepository forgetCodeRepository;
    @Override
    @Transactional
    public void sender(EmailRequest emailRequest) {
        Optional<User> byEmail = userRepository.findByEmail(emailRequest.getRecipient());
        if(byEmail.isEmpty()) {
            throw new NotFoundIdException("User","Email", emailRequest.getRecipient());
        }
        String code = SystemUtils.getCode();
        ForgetCode forgetCode = ForgetCode.builder()
                .code(code)
                .user(byEmail.get())
                .revoked(false).build();
        if(byEmail.get().getForgetCode() != null) {
            forgetCode = byEmail.get().getForgetCode();
            forgetCode.setRevoked(false);
            forgetCode.setCode(code);
        }
        forgetCodeRepository.save(forgetCode);

        emailRequest.setMsgBody(byEmail.get().getUsername(), code, urlFrontEnd);
        Thread emailThread = new Thread(new EmailSender(emailSender,
                emailRequest,
                javaMailSender), "SendEmailTask");
        System.out.println(emailThread.getName() + " is running");
        emailThread.start();
    }
}
