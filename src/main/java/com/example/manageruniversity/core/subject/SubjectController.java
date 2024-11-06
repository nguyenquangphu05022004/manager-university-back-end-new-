package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.common.pojo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public CommonResult<SubjectDto> update(@RequestBody SubjectDto subjectDto) {
        return success(new SubjectDto(subjectService.create(subjectDto)));
    }

    @GetMapping
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
