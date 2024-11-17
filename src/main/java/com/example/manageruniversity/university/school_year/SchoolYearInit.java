package com.example.manageruniversity.university.school_year;

import com.example.manageruniversity.common.collection.CollUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SchoolYearInit {
    private final SchoolYearRepository schoolYearRepository;
    @PostConstruct
    void init() {
        if(CollUtils.isEmpty(schoolYearRepository.findAll())) {
            List<SchoolYear> schoolYears = List.of(
                    new SchoolYear(2022, 2023, Semester.SEMESTER_1),
                    new SchoolYear(2022, 2023, Semester.SEMESTER_2),
                    new SchoolYear(2022, 2023, Semester.SEMESTER_3),
                    new SchoolYear(2023, 2024, Semester.SEMESTER_1),
                    new SchoolYear(2023, 2024, Semester.SEMESTER_2),
                    new SchoolYear(2023, 2024, Semester.SEMESTER_3)
            );
            schoolYears.forEach(s -> this.schoolYearRepository.save(s));
        }
    }

}
