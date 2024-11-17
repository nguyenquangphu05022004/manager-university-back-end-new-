package com.example.manageruniversity.university.tuition.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.university.tuition.controller.vo.AmountPerCreditReqVO;
import com.example.manageruniversity.university.tuition.controller.vo.AmountPerCreditResVO;
import com.example.manageruniversity.university.tuition.service.tuition.AmountPerCreditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/amount-per-credit")
@Tag(name = "Amount Per Credit - Gia cua 1 tin chi")
public class AmountPerCreditController {


    private final AmountPerCreditService amountPerCreditService;

    @Operation(summary = "create")
    @PostMapping
    @PreAuthorize("@ss.hasPermission('amount-per-credit:create')")
    public CommonResult<?> create(@RequestBody AmountPerCreditReqVO amount) {
        this.amountPerCreditService.create(amount);
        return CommonResult.success("ok");
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update")
    @PreAuthorize("@ss.hasPermission('amount-per-credit:update')")
    public CommonResult<?> update(@PathVariable("id") Long id, @RequestBody AmountPerCreditReqVO amount) {
        this.amountPerCreditService.update(id, amount);
        return CommonResult.success("ok");
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @PreAuthorize("@ss.hasPermission('amount-per-credit:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long id) {
        this.amountPerCreditService.delete(id);
        return CommonResult.success("ok");
    }

    @GetMapping
    @Operation(summary = "Get list amount per credit")
    @PreAuthorize("@ss.hasPermission('amount-per-credit:get-list')")
    public CommonResult<List<AmountPerCreditResVO>> getList() {
        return CommonResult.success(amountPerCreditService.getList(), AmountPerCreditResVO::new);
    }

}
