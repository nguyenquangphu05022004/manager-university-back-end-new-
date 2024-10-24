package com.example.manageruniversity.domain.account;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tokens")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token extends BaseEntity {
    private String token;
    private boolean expired;
    private boolean revoked;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
