package com.example.manageruniversity.university.instruction;

import java.util.List;

public interface MajorSubjectSelectionService {
    MajorSubjectSelection create(MajorSubjectSelectionRequest request);
    void delete(Long id);

    /**
     * findAllBy: major and course, schoolYearId and course, schoolYearId and CourseId and MajorId
     * @param condition: combine all the keys major, schoolYear and course for filter
     * @return: result that we need
     */
//    List<MajorSubjectSelection> findAllByCondition(Condition condition);

    void removeSubject(Long majorSelectionId, String subjectId);
    void addSubject(AddSubjectRequest request);


    List<MajorSubjectSelection> getAll();
}
