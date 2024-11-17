package com.example.manageruniversity.university.notification.dal.entities;

import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notification_post")
@Getter
@NoArgsConstructor
public class Post extends SubBaseEntity {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(Long id, String title, String content) {
        setId(id);
        this.title = title;
        this.content = content;
    }
}
