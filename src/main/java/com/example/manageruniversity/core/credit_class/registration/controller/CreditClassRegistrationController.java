package com.example.manageruniversity.core.credit_class.registration.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.core.credit_class.registration.domain.dto.request.CreditClassRegistrationRequest;
import com.example.manageruniversity.core.credit_class.registration.domain.dto.response.CreditClassRegistrationDto;
import com.example.manageruniversity.core.credit_class.registration.service.CreditClassRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-class/registration")
public class CreditClassRegistrationController {

    private final CreditClassRegistrationService creditClassRegistrationService;


    @PostMapping
    @PreAuthorize("@ss.hasPermission('credit-class-registration:create')")
    public CommonResult<CreditClassRegistrationDto> create(@RequestBody CreditClassRegistrationRequest request) {
        return success(new CreditClassRegistrationDto(creditClassRegistrationService.create(request)));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('credit-class-registration:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long id) {
        this.creditClassRegistrationService.delete(id);
        return success("delete ok");
    }


    @GetMapping
    @PreAuthorize("@ss.hasPermission('credit-class-registration:get-list')")
    public CommonResult<List<CreditClassRegistrationDto>> getListByStudentIdAndSchoolYearId(
            @RequestParam("studentId") String studenId,
            @RequestParam("schoolYearId") Long schoolYearId
    ) {
        return success(this.creditClassRegistrationService.getListByStudentIdAndSchoolYearId(studenId, schoolYearId), CreditClassRegistrationDto::new);
    }

}
