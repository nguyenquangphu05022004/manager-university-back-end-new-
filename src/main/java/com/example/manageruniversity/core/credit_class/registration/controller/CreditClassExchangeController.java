package com.example.manageruniversity.core.credit_class.registration.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.core.credit_class.registration.domain.dto.request.CreditClassExchangeRequest;
import com.example.manageruniversity.core.credit_class.registration.domain.dto.response.CreditClassExchangeDto;
import com.example.manageruniversity.core.credit_class.registration.service.CreditClassExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-class/exchange")
@CrossOrigin("*")
public class CreditClassExchangeController {
    private final CreditClassExchangeService creditClassExchangeService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('credit-class-exchange:sendRequest')")
    public CommonResult<CreditClassExchangeDto> sendRequest(@RequestBody CreditClassExchangeRequest request) {
        return success(new CreditClassExchangeDto(creditClassExchangeService.sendRequest(request)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('credit-class-exchange:processAccept')")
    public CommonResult<?> processAccept(
            @PathVariable("id") Long id
    ) {
        this.creditClassExchangeService.processAccept(id);
        return success("update ok");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('credit-class-exchange:processDelete')")
    public CommonResult<?> processDelete(@PathVariable("id") Long id) {
        this.creditClassExchangeService.processDelete(id);
        return success("delete ok");
    }


    @GetMapping
    @PreAuthorize("@ss.hasPermission('credit-class-exchange:getListExchangeByStudentAndCreditClass')")
    public CommonResult<List<CreditClassExchangeDto>> getListExchangeByStudentAndCreditClass(
            @RequestParam("studentId") String studentId,
            @RequestParam("creditClassId") Long creditClassId
    ) {
        return success(this.creditClassExchangeService.getListByStudentIdAndCreditClassId(
                studentId, creditClassId
        ), CreditClassExchangeDto::new);
    }


}
