package com.example.manageruniversity.university.school_year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
    @Query("select s from SchoolYear s \n " +
            "where s.id in \n " +
            "(select m.schoolYear.id \n " +
            "from MajorSubjectSelection m \n " +
            "where m.course.courseId = :courseId)")
    List<SchoolYear> findAllByCourseId(String courseId);
}
