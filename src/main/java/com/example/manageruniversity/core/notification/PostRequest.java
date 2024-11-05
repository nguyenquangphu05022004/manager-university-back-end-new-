package com.example.manageruniversity.core.notification;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class PostRequest {
    private Long id;
    private String title;
    private String content;
}
