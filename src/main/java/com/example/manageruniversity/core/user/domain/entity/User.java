package com.example.manageruniversity.core.user.domain.entity;

import com.example.manageruniversity.core.user.domain.enums.Role;
import com.example.manageruniversity.share.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Setter
    private Role role;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(unique = true)
    private String email;

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
