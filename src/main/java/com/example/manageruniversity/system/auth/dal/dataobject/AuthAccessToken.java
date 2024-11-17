package com.example.manageruniversity.system.auth.dal.dataobject;

import com.example.manageruniversity.university.member.dal.entities.User;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_access_token")
@NoArgsConstructor
@Getter
public class AuthAccessToken extends SubBaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Setter
    private User user;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expires;
    public AuthAccessToken(User user, String accessToken, String refreshToken) {
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
