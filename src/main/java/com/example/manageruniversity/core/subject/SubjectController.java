package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.common.pojo.CommonResult;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('subject:create')")
    public CommonResult<SubjectDto> create(@RequestBody SubjectDto subjectDto) {
        return success(new SubjectDto(subjectService.create(subjectDto)));
    }

    @GetMapping
    @PermitAll
    public CommonResult<List<SubjectDto>> getAll() {
        return success(subjectService.getAll(), SubjectDto::new);
    }

    @GetMapping("/get-by-major-school-year-course-id-{majorId}-{schoolYearId}-{courseId}")
    public CommonResult<List<SubjectDto>> getAllByMajorIdAndSchoolYearIdAndCourseId(
            @PathVariable("majorId") String majorId,
            @PathVariable("schoolYearId") Long schoolYearId,
            @PathVariable("courseId") String courseId
    ) {
        return success(
                subjectService.getAllByMajorIdAndSchoolYearIdAndCourseId(majorId, schoolYearId, courseId),
                SubjectDto::new
        );
    }
}
