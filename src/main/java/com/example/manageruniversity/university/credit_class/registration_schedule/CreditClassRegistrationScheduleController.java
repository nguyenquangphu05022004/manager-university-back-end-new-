package com.example.manageruniversity.university.credit_class.registration_schedule;

import com.example.manageruniversity.common.pojo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/api/registration-schedule")
@RequiredArgsConstructor
public class CreditClassRegistrationScheduleController {
    private final CreditClassRegistrationScheduleService creditClassRegistrationScheduleService;


    @PostMapping
    public CommonResult<CreditClassRegistrationScheduleDto> create(
            CreditClassRegistrationScheduleRequest request
    ) {
        return success(new CreditClassRegistrationScheduleDto(
                this.creditClassRegistrationScheduleService.create(request)
        ));
    }
    @GetMapping("/school-year/{schoolYearId}")
    public CommonResult<List<CreditClassRegistrationScheduleDto>> getBySchoolYear(
          @PathVariable("schoolYearId") Long schoolYearId) {
        return success(this.creditClassRegistrationScheduleService.getAllBySchoolYearId(schoolYearId), CreditClassRegistrationScheduleDto::new);
    }


    @GetMapping("/major/{majorId}")
    public CommonResult<List<CreditClassRegistrationScheduleDto>> getByMajor(
            @PathVariable("majorId") String majorId) {
        return success(this.creditClassRegistrationScheduleService.getAllByMajorId(majorId), CreditClassRegistrationScheduleDto::new);
    }


}
