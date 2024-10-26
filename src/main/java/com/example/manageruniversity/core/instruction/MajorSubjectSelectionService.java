package com.example.manageruniversity.core.instruction;

public interface MajorSubjectSelectionService {
    void create();
    void update();
    void delete();
    void getAllByStatus(boolean status);
    void getAllByCourseIdAndMajorIdAndSchoolYearId(
            String courseId,
            String majorId,
            Long schoolYearId
    );
}
