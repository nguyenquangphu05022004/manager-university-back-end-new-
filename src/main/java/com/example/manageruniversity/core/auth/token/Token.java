package com.example.manageruniversity.core.auth.token;

import com.example.manageruniversity.core.member.dal.entities.User;
import com.example.manageruniversity.share.SubBaseEntity;
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
