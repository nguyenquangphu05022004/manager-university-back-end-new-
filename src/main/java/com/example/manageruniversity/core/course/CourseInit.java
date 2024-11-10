package com.example.manageruniversity.core.course;

import com.example.manageruniversity.common.collection.CollUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CourseInit {

    private final CourseRepository courseRepository;
    @PostConstruct
    public void init() {
        List<Course> courseInDatabase = courseRepository.findAll();
        if(CollUtils.isEmpty(courseInDatabase)) {
             final List<Course> courses = List.of(
                    new Course("D22", "2022"),
                    new Course("D21", "2021"),
                    new Course("D23", "2023"),
                    new Course("D24", "2024")
            );
             courses.forEach(s -> this.courseRepository.save(s));
        }
    }
}
