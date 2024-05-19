package com.example.manageruniversity.entity.auth;

import com.example.manageruniversity.entity.Base;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "forgetCodes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForgetCode extends Base {
    private String code;
    private boolean revoked;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
