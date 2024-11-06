package com.example.manageruniversity.core.permission.domain.permission;

import com.example.manageruniversity.core.user.domain.entity.User;
import com.example.manageruniversity.share.SubBaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_permission")
public class Permission extends SubBaseEntity {
    private String name;
}
