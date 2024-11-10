package com.example.manageruniversity.permission.service;

import com.example.manageruniversity.common.collection.ArrayUtils;
import com.example.manageruniversity.common.pojo.KeyPair;
import com.example.manageruniversity.permission.domain.entity.Menu;
import com.example.manageruniversity.permission.domain.entity.MenuRole;
import com.example.manageruniversity.permission.domain.entity.RoleUser;
import com.example.manageruniversity.permission.repo.MenuRoleRepository;
import com.example.manageruniversity.permission.repo.RoleUserRepository;
import com.example.manageruniversity.permission.domain.redis.RedisPermissionConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.example.manageruniversity.common.collection.CollUtils.*;
import static com.example.manageruniversity.common.collection.MapUtils.convertToMap;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{

    private final MenuRoleRepository menuRoleRepository;
    private final RoleUserRepository roleUserRepository;
    private final StringRedisTemplate redisTemplate;

    private final RoleService roleService;
    private final MenuService menuService;

    @Override
    public boolean hasAnyPermission(Long userId, String... permissions) {
        if(ArrayUtils.isEmpty(permissions)) {
            return true;
        }
        /**
         * Get all role of user from cache
         */
        Set<Long> roleIds = new HashSet<>(this.roleService.getListEnableRoleFromCacheByUserId(userId));
        /**
         * User hasn't login yet`
         */
        if(isEmpty(roleIds)) {
            return false;
        }

        for(String permission : permissions) {
            if(hasPermission(roleIds, permission)) {
                return true;
            }
        }
        /**
         * Check whether contains super role
         */
        return this.roleService.hasAnySuperRole(roleIds);
    }

    private boolean hasPermission(Set<Long> roleIds, String permission) {
        Menu menu = this.menuService.getByPermission(permission);
        Set<Long> roleIdsWereAssignedMenu = convertToSet(this.getAllMenuRoleByMenuId(menu.getId()), r -> r.getRole().getId());

        /**
         * Role was assigned permission
         */
        if (isEmpty(roleIdsWereAssignedMenu)) {
            return false;
        }

        return hasAnyContains(roleIdsWereAssignedMenu, roleIds);

    }

    @Override
    @Transactional
    public void assignRoleForUser(Long userId, Set<Long> roleIds) {
        if(isEmpty(roleIds)) return;

        for(Long roleId : roleIds) {
            RoleUser roleUser = new RoleUser(userId, roleId);
            this.roleUserRepository.save(roleUser);
        }
        this.cache(userId, roleIds, RedisPermissionConstant.USER_LIST_ROLE);

    }

    @Override
    public void assignMenuForRole(Long roleId, Set<Long> menuIds) {
        if(isEmpty(menuIds)) return;

        for(Long menuId : menuIds) {
            MenuRole menuRole = new MenuRole(roleId, menuId);
            this.menuRoleRepository.save(menuRole);
        }
        this.cache(roleId, menuIds, RedisPermissionConstant.ROLE_LIST_MENU);
    }


    private void cache(Long id, Set<Long> ids, String constant) {
        Map<Long, List<Long>> map = convertToMap(convertToList(ids, (menuId) -> new KeyPair<>(id, menuId)));
        if(this.redisTemplate.opsForHash().hasKey(constant, id)) {
            map = (Map<Long, List<Long>>) this.redisTemplate.opsForHash().get(constant, id);
            map.get(id).addAll(ids);
        }
        this.redisTemplate.opsForHash().putAll(constant, map);
    }

    @Override
    public Set<MenuRole> getAllMenuRoleByMenuId(Long menuId) {
        return new HashSet<>(this.menuRoleRepository.findAllByMenuId(menuId));
    }

    @Override
    @Transactional
    public void processDeleteRole(Long roleId) {
        this.menuRoleRepository.deleteAllByRoleId(roleId);
        this.roleUserRepository.deleteAllByRoleId(roleId);
        this.roleService.delete(roleId);
        this.redisTemplate.delete(RedisPermissionConstant.ROLE_LIST_MENU);
        this.redisTemplate.delete(RedisPermissionConstant.USER_LIST_ROLE);
    }

    @Override
    public void processDeleteMenu(Long menuId) {
        this.menuRoleRepository.deleteAllByMenuId(menuId);
        this.menuService.delete(menuId);
        this.redisTemplate.delete(RedisPermissionConstant.ROLE_LIST_MENU);
    }
}
