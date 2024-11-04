package com.example.manageruniversity.mq.producer;

import com.example.manageruniversity.mq.message.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailProducer {
    private final ApplicationContext context;

    public void publish(String title, String content, String userId, String recepient) {
        EmailMessage message = new EmailMessage(title, content, userId, recepient);
        this.context.publishEvent(message);
    }
}
