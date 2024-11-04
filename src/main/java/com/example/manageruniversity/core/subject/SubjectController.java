package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public CommonResult<SubjectDto> update(@RequestBody SubjectDto subjectDto) {
        return CommonResult.success(new SubjectDto(subjectService.create(subjectDto)));
    }

    @GetMapping
    public PageResult<SubjectDto> getAll(@RequestParam(value = "page", defaultValue = "1") int page) {
        return PageResult.success(
                subjectService.getAll(page),
                s -> new SubjectDto(s)
        );
    }

    @GetMapping("/get-by-major-school-year-course-id-{majorId}-{schoolYearId}-{courseId}")
    public PageResult<SubjectDto> getAllByMajorIdAndSchoolYearIdAndCourseId(
            @PathVariable("majorId") String majorId,
            @PathVariable("schoolYearId") Long schoolYearId,
            @PathVariable("courseId") String courseId,
            @RequestParam(value = "page", defaultValue = "1") int page
    ) {
        return PageResult.success(
                subjectService.getAllByMajorIdAndSchoolYearIdAndCourseId(majorId, schoolYearId, courseId, page),
                s -> new SubjectDto(s)
        );
    }
}
