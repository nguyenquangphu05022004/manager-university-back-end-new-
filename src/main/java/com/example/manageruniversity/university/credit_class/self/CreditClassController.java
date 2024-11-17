package com.example.manageruniversity.university.credit_class.self;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.web.security.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit-class")
public class CreditClassController {
    private final CreditClassService creditClassService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('credit-class:create-or-update')")
    public CommonResult<CreditClassDto> createOrUpdate(@RequestBody CreditClassRequest request) {
        return success(new CreditClassDto(this.creditClassService.createOrUpdate(request)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('credit-class:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long id) {
        this.creditClassService.delete(id);
        return success("deleted successfully");
    }

    @GetMapping("/get-all-by-school-year-id-{id}")
    public CommonResult<List<CreditClassDto>> getAllBySchoolYearId(@PathVariable("id") Long schoolYearId) {
        return success(this.creditClassService.getAllBySchoolYearId(schoolYearId), c -> new CreditClassDto(c));
    }

    @GetMapping("/get-all-by-school-year-{schoolYear}-that-were-selectd-by-student-id-{studentId}")
    public CommonResult<List<CreditClassDto>> getAllBySchoolYearIdThatWereSelectedByCurrentUser(
            @PathVariable("schoolYearId") Long schoolYearId
    ) {
        return success(
                this.creditClassService.getAllBySchoolYearIdThatWereSelectedByStudentId(schoolYearId, SecurityUtils.getLoginUserId()),
                s -> new CreditClassDto(s));
    }

    @GetMapping("/get-all-by-school-year-{schoolYearId}-and-teacher-id-{teacherId}")
    public CommonResult<List<CreditClassDto>> getAllBySchoolYearIdAndTeacherId(
            @PathVariable("schoolYearId") Long schoolYearId,
            @PathVariable("teacherId") Long teacherId
    ) {
        return success(
                this.creditClassService.getAllBySchoolYearIdAndTeacherId(schoolYearId, teacherId),
                s -> new CreditClassDto(s));
    }

}
