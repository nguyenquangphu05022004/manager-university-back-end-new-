package com.example.manageruniversity.mq.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailMessage {
    private String title;
    private String content;
    private String userId;
    private String recepient;
}
