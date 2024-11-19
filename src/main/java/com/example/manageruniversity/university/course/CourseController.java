package com.example.manageruniversity.university.course;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.excel.utils.ExcelUtils;
import com.example.manageruniversity.common.operatelog.annotation.OperateLog;
import com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum;
import com.example.manageruniversity.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.operatelog.enums.OperateTypeEnum.EXPORT;
import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
@Tag(name = "Course - khoa hoc")
@CrossOrigin("*")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('course:create')")
    @Operation(
            description = "Tao khoa hoc moi khi co 1 dot tuyen sinh",
            summary = "Tao khoa hoc"
    )
    public CommonResult<CourseDto> create(@RequestBody CourseRequest courseRequest) {
        return success(new CourseDto(this.courseService.update(courseRequest)));
    }

    @GetMapping
    public CommonResult<List<CourseDto>> getAll() {
        return success(courseService.getAll(), CourseDto::new);
    }

    @GetMapping("/{courseId}")
    public CommonResult<CourseDto> getById(@PathVariable("courseId") String courseId) {
        return success(new CourseDto(this.courseService.getById(courseId)));
    }


    @PostMapping("/export")
    @Operation(summary = "export data Courses to file excel")
    @OperateLog(type = EXPORT)
    public CommonResult<Boolean> export(HttpServletResponse response) {
        List<CourseDto> courses = ListUtils.convertToList(this.courseService.getAll(), CourseDto::new);
        /**
         * Custom util for write excel
         */
        ExcelUtils.write(response, "courses.xls", CourseDto.class, courses);
        return CommonResult.success(true);
    }
}
