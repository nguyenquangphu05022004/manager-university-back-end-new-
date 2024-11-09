package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.permission.domain.redis.RedisPermissionConstant;
import com.example.manageruniversity.core.permission.domain.role.Role;
import com.example.manageruniversity.core.permission.domain.role.RoleRequest;
import com.example.manageruniversity.core.permission.domain.role.RoleUser;
import com.example.manageruniversity.core.permission.domain.role.RoleUserRequest;
import com.example.manageruniversity.core.permission.repo.RoleRepository;
import com.example.manageruniversity.core.permission.repo.RoleUserRepository;
import com.example.manageruniversity.core.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private final RoleUserRepository roleUserRepository;
    private final RedisTemplate<String, String> redisTemplate;
    @Override
    public Role createRole(RoleRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Role role = new Role(request.getName());
        this.roleRepository.save(role);
        return role;
    }

    @Override
    public Role updateRole(Long roleId, RoleRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourcesNotFoundException("role not found"));
        role.setName(role.getName());
        this.roleRepository.save(role);
        return role;
    }

    @Override
    public void deleteById(Long roleId) {
        this.roleRepository.deleteById(roleId);
    }


    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public List<Role> getAllRoleByUser(Long userId) {
        return null;
    }

    @Override
    public void assignRoleForUser(RoleUserRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        RoleUser roleUser = new RoleUser(
                new User(request.getUserId()),
                new Role(request.getRoleId())
        );
        this.roleUserRepository.save(roleUser);
    }

    @Override
    public void revokeRoleFromUser(RoleUserRequest request) {
        this.roleUserRepository.deleteByUserIdAndRoleId(
                request.getUserId(),
                request.getRoleId()
        );
    }

    @Override
    public boolean userHasRole(Long userId, String role) {
        String key = String.format(RedisPermissionConstant.USER_ROLE, userId, role);
        if(this.redisTemplate.hasKey(key)) {
            return true;
        }
        boolean userRole = this.roleUserRepository
                .findByUserIdAndRoleName(userId, role)
                .isPresent();

        if(userRole) {
            this.redisTemplate.opsForValue().set(key, "ok", Duration.ofHours(1));
            return true;
        }
        return false;
    }

    @Override
    public boolean userHasAnyRole(Long userId, String... roles) {
        for(String role : roles) {
            return this.userHasRole(userId, role);
        }
        return false;
    }

}
