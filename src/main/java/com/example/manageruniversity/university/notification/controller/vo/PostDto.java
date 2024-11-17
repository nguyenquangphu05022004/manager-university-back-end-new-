package com.example.manageruniversity.university.notification.controller.vo;

import com.example.manageruniversity.university.notification.dal.entities.Post;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String owner;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.owner = post.getCreatedBy();
    }
}
