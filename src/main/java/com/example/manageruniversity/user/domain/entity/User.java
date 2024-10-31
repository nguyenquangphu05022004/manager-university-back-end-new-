package com.example.manageruniversity.user.domain.entity;

import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.user.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_user")
@Getter
public  class User extends BaseEntity implements UserDetails {

    @Id
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String entityId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
