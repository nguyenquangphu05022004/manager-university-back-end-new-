package com.example.manageruniversity.core.course.controller;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.string.StringUtils;
import com.example.manageruniversity.core.course.domain.dto.CourseDto;
import com.example.manageruniversity.core.course.domain.request.CourseRequest;
import com.example.manageruniversity.core.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public void create(@RequestBody CourseRequest courseRequest,
                       @RequestParam(value = "courseId", required = false) String courseId) {
        if(!StringUtils.isEmpty(courseId)) {
            courseRequest.setCourseId(courseId);
        }
        this.courseService.update(courseRequest);
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return ListUtils.convert(
                CourseDto.class,
                this.courseService.getAll()
        );
    }

    @GetMapping("/{courseId}")
    public CourseDto getById(@PathVariable("courseId") String courseId) {
        return ObjectUtils.init(CourseDto.class,this.courseService.getById(courseId));
    }
}
