package com.example.manageruniversity.core.schoolYear;

public interface SchoolYearService {
    void create();
    void update();
    void selectAllByCourseId(String courseId);
}
