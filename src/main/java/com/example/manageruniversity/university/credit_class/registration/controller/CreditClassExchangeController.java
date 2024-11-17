package com.example.manageruniversity.university.credit_class.registration.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.web.security.utils.SecurityUtils;
import com.example.manageruniversity.university.credit_class.registration.domain.dto.request.CreditClassExchangeReqVO;
import com.example.manageruniversity.university.credit_class.registration.domain.dto.response.CreditClassExchangeDto;
import com.example.manageruniversity.university.credit_class.registration.service.CreditClassExchangeService;
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
    public CommonResult<CreditClassExchangeDto> sendRequest(@RequestBody CreditClassExchangeReqVO request) {
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


    /**
     * lay toan bo cac request duoc gui toi user hien tai
     * cho viec trao doi lop hoc voi nhau
     * @param creditClassId
     * @return
     */
    @GetMapping
    @PreAuthorize("@ss.hasPermission('credit-class-exchange:getListExchangeByStudentAndCreditClass')")
    public CommonResult<List<CreditClassExchangeDto>> getListRequestExchangeOfCreditClassToCurrentUser(
            @RequestParam("creditClassId") Long creditClassId
    ) {
        return success(
                this.creditClassExchangeService.getListByStudentIdAndCreditClassId(
                SecurityUtils.getLoginUserId(), creditClassId),
                CreditClassExchangeDto::new);
    }


}
