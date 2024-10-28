package com.example.manageruniversity.score.service;

public interface ScoreService {
    void initForAllStudentBySchoolYearId(Long schoolYearId);
    void getAllByStudentId(String studentId);
}
