package com.example.manageruniversity.core.user.domain.entity;

import com.example.manageruniversity.core.user.domain.enums.Role;
import com.example.manageruniversity.share.BaseEntity;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "sys_user")
@Getter
@NoArgsConstructor
public  class User extends SubBaseEntity implements UserDetails {

    @Column(unique = true)
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

    public User(Long id) {
        setId(id);
    }

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
