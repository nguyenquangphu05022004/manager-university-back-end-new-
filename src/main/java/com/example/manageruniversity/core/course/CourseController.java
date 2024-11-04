package com.example.manageruniversity.core.course;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.common.string.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public CommonResult<CourseDto> create(@RequestBody CourseRequest courseRequest,
                               @RequestParam(value = "courseId", required = false) String courseId) {
        if(!StringUtils.isEmpty(courseId)) {
            courseRequest.setCourseId(courseId);
        }
        return CommonResult.success(new CourseDto(this.courseService.update(courseRequest)));
    }

    @GetMapping
    public PageResult<CourseDto> getAll(int page) {
        return PageResult.success(
                this.courseService.getAll(page),
                (course) -> new CourseDto(course));
    }

    @GetMapping("/{courseId}")
    public CommonResult<CourseDto> getById(@PathVariable("courseId") String courseId) {
        return CommonResult.success(new CourseDto(this.courseService.getById(courseId)));
    }
}
