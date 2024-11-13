package com.example.manageruniversity.core.member.dal.entities;

import com.example.manageruniversity.core.member.domain.enums.MemberType;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sys_user")
@Data
@NoArgsConstructor
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
public  class User extends SubBaseEntity implements UserDetails {

    @Column(unique = true)
    private String username;
    @Setter
    private String password;
    @Enumerated(EnumType.STRING)
    @Setter
    private MemberType memberType;
    @Column(unique = true)
    private String email;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private Boolean sex;
    private String avatar;
    public User(Long id) {
        setId(id);
    }

    public User(String username, String password, MemberType memberType, String email, String fullName, String address, String phoneNumber, Date dateOfBirth, Boolean sex) {
        this.username = username;
        this.password = password;
        this.memberType = memberType;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + memberType.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
