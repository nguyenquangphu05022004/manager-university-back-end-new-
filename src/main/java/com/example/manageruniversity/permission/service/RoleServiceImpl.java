package com.example.manageruniversity.permission.service;

import com.example.manageruniversity.common.collection.CollUtils;
import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.json.JsonUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.permission.domain.redis.RedisPermissionConstant;
import com.example.manageruniversity.permission.repo.RoleRepository;
import com.example.manageruniversity.permission.controller.dto.RoleDto;
import com.example.manageruniversity.permission.domain.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final StringRedisTemplate redisTemplate;
    private final RoleRepository roleRepository;
    @Override
    @Transactional()
    public Role create(RoleDto roleDto) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(roleDto, "id");
        Optional<Role> opRole = this.roleRepository.findByName(roleDto.getName());
        if(opRole.isPresent()) {
            //throw exception
        }
        Role role = new Role(roleDto.getName(), roleDto.getRoleType());
        this.roleRepository.save(role);
        return role;
    }

    @Override
    public Role update(RoleDto roleDto) {
        Role role = this.roleRepository.findById(roleDto.getId())
                .orElseThrow(() -> new ResourcesNotFoundException("not found role"));
        if(this.roleRepository.findByName(roleDto.getName()).isPresent()) {
            //throw exception
        }
        role.setName(roleDto.getName());
        role.setRoleType(roleDto.getRoleType());
        this.roleRepository.save(role);
        return role;
     }

    @Override
    public void delete(Long id) {
        this.roleRepository.deleteById(id);
    }

    @Override
    public Role getById(Long id) {
        if(this.redisTemplate.hasKey(RedisPermissionConstant.ROLE_LIST)) {
            return JsonUtils.read(
                    (String)this.redisTemplate.opsForHash().get(RedisPermissionConstant.ROLE_LIST, String.valueOf(id)),
                    Role.class
            );
        }
        Role role = this.roleRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("role not found"));

        String json = JsonUtils.write(role);
        this.redisTemplate.opsForHash().put(RedisPermissionConstant.ROLE_LIST, String.valueOf(id), json);
        return role;
    }


    @Override
    public List<Long> getListEnableRoleFromCacheByUserId(Long userId) {
        Boolean isExists = this.redisTemplate.opsForHash().hasKey(RedisPermissionConstant.USER_LIST_ROLE, userId);
        if(isExists) {
            Map<Long, List<Long>> result = (Map<Long, List<Long>>) this.redisTemplate.opsForHash().get(RedisPermissionConstant.USER_LIST_ROLE, userId);
            return result.get(userId);
        }
        return null;
    }

    @Override
    public List<Role> getList() {
        if(this.redisTemplate.hasKey(RedisPermissionConstant.ROLE_LIST)) {
            Map<Object, Object> entries = this.redisTemplate.opsForHash().entries(RedisPermissionConstant.ROLE_LIST);
            return ListUtils.convertToList(entries.entrySet(), entry -> JsonUtils.read((String) entry.getValue(), Role.class));
        } else {
            List<Role> roles = this.roleRepository.findAll();
            roles.forEach(role -> {
                this.redisTemplate.opsForHash().put(RedisPermissionConstant.ROLE_LIST, String.valueOf(role.getId()), JsonUtils.write(role));
            });
            return roles;
        }
    }


    @Override
    public boolean hasAnySuperRole(Collection<Long> ids) {
        if(CollUtils.isEmpty(ids)) {
            return false;
        }
        return ids.stream().anyMatch(id -> {
            Role role = JsonUtils.read((String) this.redisTemplate.opsForHash().get(RedisPermissionConstant.ROLE_LIST, String.valueOf(id)), Role.class);
            if(role.getRoleType() == Role.RoleType.SUPER_ADMIN) {
                return true;
            }
            return false;
        });
    }
}
