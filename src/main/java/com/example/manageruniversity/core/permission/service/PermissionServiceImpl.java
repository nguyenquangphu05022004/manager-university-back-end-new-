package com.example.manageruniversity.core.permission.service;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.permission.domain.menu.Menu;
import com.example.manageruniversity.core.permission.domain.menu.MenuPermission;
import com.example.manageruniversity.core.permission.domain.permission.Permission;
import com.example.manageruniversity.core.permission.domain.permission.PermissionRequest;
import com.example.manageruniversity.core.permission.repo.MenuPermissionRepository;
import com.example.manageruniversity.core.permission.repo.PermissionRepository;
import com.example.manageruniversity.core.permission.repo.UserMenuPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

import static com.example.manageruniversity.core.permission.domain.redis.RedisPermissionConstant.USER_PERMISSION;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;
    private final MenuPermissionRepository menuPermissionRepository;
    private final UserMenuPermissionRepository userMenuPermissionRepository;
    private final RedisTemplate<String, String> redisTemplate;
    @Override
    public Permission createPermission(PermissionRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        Permission permission = new Permission(request.getName());
        this.permissionRepository.save(permission);
        return permission;
    }

    @Override
    public Permission updatePermission(Long permissionId, PermissionRequest request) {
        Permission permission = this.permissionRepository
                .findById(permissionId)
                .orElseThrow(() -> new ResourcesNotFoundException("permission not found"));
        permission.setName(request.getName());
        this.permissionRepository.save(permission);
        return permission;
    }

    @Override
    @Transactional
    public void deletePermission(Long id) {
        this.menuPermissionRepository.deleteAllByPermissionId(id);
        this.permissionRepository.deleteById(id);
    }

    @Override
    public List<Permission> getAll() {
        return this.permissionRepository.findAll();
    }

    @Override
    public boolean permissionHasMenuAction(String permission, Menu.Action action) {
        MenuPermission menuPermission = this.menuPermissionRepository
                .findByPermissionNameAndMenuAction(permission, action)
                .orElse(null);
        if(menuPermission == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean userHasPermissionAndMenuAction(Long userId, String permission, Menu.Action action) {
//        String key = String.format(USER_PERMISSION, userId, permission, action);
//        if(redisTemplate.hasKey(key)) {
//            return Boolean.getBoolean(redisTemplate.opsForValue().get(key));
//        }
//        boolean res = this.permissionHasMenuAction(permission, action);
//        if(res) {
//            res =  this.userMenuPermissionRepository
//                    .findByUserIdAndMenuPermissionId(userId, )
//        }
//        redisTemplate.opsForValue().set(key, String.valueOf(res), Duration.ofHours(1));
//        return res;
        return true;
    }


}
