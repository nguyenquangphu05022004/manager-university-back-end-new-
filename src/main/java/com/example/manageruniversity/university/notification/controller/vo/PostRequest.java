package com.example.manageruniversity.university.notification.controller.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostRequest {
    private Long id;
    private String title;
    private String content;
}
