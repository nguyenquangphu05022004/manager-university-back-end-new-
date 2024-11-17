package com.example.manageruniversity.system.mail;

import com.example.manageruniversity.mq.message.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromMail;
    public void sendMail(EmailMessage message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSentDate(new Date(System.currentTimeMillis()));
        mailMessage.setText(message.getContent());
        mailMessage.setSubject(message.getTitle());
        mailMessage.setFrom(fromMail);
        mailMessage.setTo(message.getRecepient());
        this.mailSender.send(mailMessage);
    }
}
