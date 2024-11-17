package com.example.manageruniversity.system.permission.controller;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.system.permission.controller.dto.RoleDto;
import com.example.manageruniversity.system.permission.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@PreAuthorize("@ss.hasRole('SUPER_ADMIN')")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public CommonResult<?> createRole(@RequestBody RoleDto request) {
        this.roleService.create(request);
        return success("created role success");
    }

    @PutMapping
    public CommonResult<?> updateRole(@RequestBody RoleDto request) {
        this.roleService.update(request);
        return success("updated role success");
    }

    @GetMapping
    public CommonResult<List<RoleDto>> getAll() {
        return success(ListUtils.convertToList(this.roleService.getList(), RoleDto::new));
    }

}
