package com.example.manageruniversity.courses.credit_class_schedule.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.courses.credit_class_schedule.CreditClassRegistrationScheduleDto;
import com.example.manageruniversity.courses.credit_class_schedule.CreditClassRegistrationScheduleRequest;
import com.example.manageruniversity.courses.credit_class_schedule.CreditClassRegistrationScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-class/registration/schedule")
@RequiredArgsConstructor
public class CreditClassRegistrationScheduleController {
    private final CreditClassRegistrationScheduleService creditClassRegistrationScheduleService;


    @PostMapping
    public CommonResult<CreditClassRegistrationScheduleDto> create(
            CreditClassRegistrationScheduleRequest request
    ) {
        return CommonResult.success(new CreditClassRegistrationScheduleDto(
                this.creditClassRegistrationScheduleService.create(request)
        ));
    }
    @GetMapping("/school-year/{schoolYearId}")
    public PageResult<CreditClassRegistrationScheduleDto> getBySchoolYear(
          @PathVariable("schoolYearId") Long schoolYearId,
          @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        return PageResult.success(
                this.creditClassRegistrationScheduleService.getAllBySchoolYearId(
                        schoolYearId,
                        page
                ),
                (cre) -> new CreditClassRegistrationScheduleDto(cre)
        );
    }


    @GetMapping("/major/{majorId}")
    public PageResult<CreditClassRegistrationScheduleDto> getByMajor(
            @PathVariable("majorId") String majorId,
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        return PageResult.success(
                this.creditClassRegistrationScheduleService.getAllByMajorId(
                        majorId,
                        page
                ),
                (cre) -> new CreditClassRegistrationScheduleDto(cre)
        );
    }


}
