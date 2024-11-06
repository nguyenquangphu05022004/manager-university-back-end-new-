package com.example.manageruniversity.core.course;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.string.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public CommonResult<CourseDto> create(@RequestBody CourseRequest courseRequest,
                               @RequestParam(value = "courseId", required = false) String courseId) {
        if(!StringUtils.isEmpty(courseId)) {
            courseRequest.setCourseId(courseId);
        }
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
}
