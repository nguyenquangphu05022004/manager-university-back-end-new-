package com.example.manageruniversity.university.course;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
                course = new Course(
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
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
    @Override
    public Course getById(String courseId) {
        return this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourcesNotFoundException("Course not found"));
    }
}
