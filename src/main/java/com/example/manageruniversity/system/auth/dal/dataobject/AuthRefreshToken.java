package com.example.manageruniversity.system.auth.dal.dataobject;

import com.example.manageruniversity.university.member.dal.entities.User;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_refresh_token")
@Getter
@NoArgsConstructor
public class AuthRefreshToken extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String refreshToken;
    private LocalDateTime expires;
    public AuthRefreshToken(Long user, String refreshToken) {
        this.user = new User(user);
        this.refreshToken = refreshToken;
    }
}
