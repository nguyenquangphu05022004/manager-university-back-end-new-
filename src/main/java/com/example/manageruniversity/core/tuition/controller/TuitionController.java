package com.example.manageruniversity.core.tuition.controller;


import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.security.SecurityUtils;
import com.example.manageruniversity.core.tuition.api.VNPayAPI;
import com.example.manageruniversity.core.tuition.controller.vo.TuitionBaseResVO;
import com.example.manageruniversity.core.tuition.service.tuition.TuitionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tuitions")
@Tag(name = "Tuition - Hoc phi")
public class TuitionController {

    private final TuitionService tuitionService;
    private final VNPayAPI vnPayAPI;

    @Operation(summary = "Lay toan bo thong tin hoc phi cua sinh vien")
    @GetMapping
    @PreAuthorize("@ss.hasPermission('tuition:get-list')")
    public CommonResult<List<TuitionBaseResVO>> getListByStudent() {
        return success(tuitionService.getAllByStudentId(SecurityUtils.userIdLogin()), TuitionBaseResVO::new);
    }

    @Operation(summary = "Tao hoc phi cho sinh vien")
    @PostMapping("/school-year/{schoolYearId}/course/{courseId}")
    @PreAuthorize("@ss.hasPermission('tuition:init')")
    public CommonResult<?> init(
            @PathVariable("schoolYearId") Long schoolYearId,
            @PathVariable("courseId") String courseId
    ) {
        this.tuitionService.createForAllStudentBySchoolYearIdAndCourseId(schoolYearId, courseId);
        return success("ok");
    }

}
