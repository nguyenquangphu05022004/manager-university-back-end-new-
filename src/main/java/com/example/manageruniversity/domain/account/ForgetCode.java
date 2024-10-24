package com.example.manageruniversity.domain.account;

import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "forgetCodes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForgetCode extends BaseEntity {
    private String code;
    private boolean revoked;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
