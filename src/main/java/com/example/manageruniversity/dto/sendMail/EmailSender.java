package com.example.manageruniversity.dto.sendMail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Getter
@AllArgsConstructor
@Setter
public class EmailSender implements Runnable{
    private String emailSender;
    private EmailRequest emailRequest;
    private JavaMailSender javaMailSender;

    @Override
    public void run() {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, "utf-8");
            mimeMessageHelper.setFrom(emailSender);
            mimeMessageHelper.setTo(emailRequest.getRecipient());
            mimeMessageHelper.setText(emailRequest.getMsgBody(), true);
            mimeMessageHelper.setSubject(emailRequest.getSubject());
            javaMailSender.send(mailMessage);
            System.out.println("Send email success!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
