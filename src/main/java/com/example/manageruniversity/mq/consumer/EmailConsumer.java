package com.example.manageruniversity.mq.consumer;


import com.example.manageruniversity.mq.message.EmailMessage;
import com.example.manageruniversity.third.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final MailService mailService;

    @EventListener
    @Async
    public void consumer(EmailMessage message) {
        this.mailService.sendMail(message);
    }
}
