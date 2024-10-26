package com.example.manageruniversity.core.course;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public void create(@RequestBody CourseRequest courseRequest) {
        this.courseService.create(courseRequest);
    }

    @PostMapping("/{courseId}")
    public void update(@PathVariable("courseId") Long courseId,
                       @RequestBody CourseRequest courseRequest) {
        this.courseService.update(courseId,courseRequest);
    }

    @GetMapping
    public void getAll() {
        this.courseService.selectAll();
    }

    @GetMapping("/{courseId}")
    public void getById(@PathVariable("courseId") Long courseId) {
        this.courseService.selectById(courseId);
    }
}
