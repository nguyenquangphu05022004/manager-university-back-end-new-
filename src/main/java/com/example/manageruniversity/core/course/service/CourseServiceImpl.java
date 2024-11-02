package com.example.manageruniversity.core.course.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.core.course.domain.entity.Course;
import com.example.manageruniversity.core.course.domain.request.CourseRequest;
import com.example.manageruniversity.core.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course update(CourseRequest courseRequest) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(courseRequest);
        Course course = this.courseRepository.findById(courseRequest.getCourseId())
                .orElse(null);
        try {
            if(ObjectUtils.isNull(course)) {
                course = new com.example.manageruniversity.core.course.domain.entity.Course(
                        courseRequest.getCourseId(),
                        courseRequest.getName());
            } else {
                course.setName(courseRequest.getName());
            }
            this.courseRepository.save(course);
            return course;
        } catch (Exception e) {
            log.error("Course id or value is repeated");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<Course> getAll(int page) {
        return this.courseRepository.findAll(PageRequest.of(page - 1, PageConstant.LIMIT));
    }

    @Override
    public Course getById(String courseId) {
        return this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourcesNotFoundException("Course not found"));
    }
}
