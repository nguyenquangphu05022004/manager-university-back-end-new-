package com.example.manageruniversity.domain;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostNotification extends BaseEntity {
    private String title;
    @Column(columnDefinition = "text")
    private String content;
}
