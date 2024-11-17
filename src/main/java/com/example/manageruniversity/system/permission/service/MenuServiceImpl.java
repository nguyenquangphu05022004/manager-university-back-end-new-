package com.example.manageruniversity.system.permission.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.exception.ServiceException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.system.permission.controller.dto.MenuDto;
import com.example.manageruniversity.system.permission.domain.entity.Menu;
import com.example.manageruniversity.system.permission.repo.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Long create(MenuDto menuDto) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(menuDto, "id");
        Menu menu = new Menu(menuDto.getName(), menuDto.getPermission());
        this.menuRepository.save(menu);
        return menu.getId();
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public Long update(MenuDto menuDto) {
        Menu menu = this.menuRepository.findById(menuDto.getId())
                .orElseThrow(() -> new ResourcesNotFoundException("not found menu"));
        menu.setName(menuDto.getName());
        menu.setPermission(menuDto.getPermission());
        this.menuRepository.save(menu);
        return menu.getId();
    }

    @Override
    public void delete(Long id) {
        this.menuRepository.deleteById(id);
    }

    @Override
    public Menu getByPermission(String permission) {
        return this.menuRepository
                .findByPermission(permission)
                .orElseThrow(() -> new ResourcesNotFoundException("menu not found"));
    }
}
