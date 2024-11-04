package com.example.manageruniversity.core.score.service;

public interface ScoreService {
    void initForAllStudentBySchoolYearId(Long schoolYearId);
    void getAllByStudentId(String studentId);
}
