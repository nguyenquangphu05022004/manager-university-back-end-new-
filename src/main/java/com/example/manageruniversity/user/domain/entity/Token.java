package com.example.manageruniversity.user.domain.entity;

import com.example.manageruniversity.share.SubBaseEntity;
import com.example.manageruniversity.user.domain.enums.TokenType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tokens")

@NoArgsConstructor
@AllArgsConstructor
public class Token extends SubBaseEntity {
    @Getter
    private String token;
    @Getter
    private String refreshToken;
    @Getter
    @Setter
    private boolean revoked;
    @Enumerated(EnumType.STRING)
    @Getter
    private TokenType tokenType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
