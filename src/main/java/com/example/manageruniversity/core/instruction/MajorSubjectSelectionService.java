package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.filter.Condition;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MajorSubjectSelectionService {
    MajorSubjectSelection create(MajorSubjectSelectionRequest request);
    void delete(Long majorSSlId);

    /**
     * findAllBy: major and course, schoolYearId and course, schoolYearId and CourseId and MajorId
     * @param condition: combine all the keys major, schoolYear and course for filter
     * @return: result that we need
     */
    Page<MajorSubjectSelection> findAllByCondition(Condition condition, int page);
}
