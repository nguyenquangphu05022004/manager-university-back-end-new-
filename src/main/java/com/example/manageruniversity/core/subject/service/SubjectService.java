package com.example.manageruniversity.core.subject.service;

import com.example.manageruniversity.core.subject.domain.dto.SubjectDto;
import com.example.manageruniversity.core.subject.domain.entity.Subject;
import com.example.manageruniversity.core.subject.domain.request.SubjectFilterCondition;
import com.example.manageruniversity.filter.Condition;

import java.util.List;

public interface SubjectService {
    Subject create(SubjectDto subjectDto);
    List<Subject> getAll();
    Subject getById(String subjectId);

    /**
     * Lay toan bo thong tin ve mon hoc theo nam hoc
     *  select s.*
     *  from subject s
     *  where s.subject_id = (
     *     select mss.subject_id
     *     from major_subject_selection mss
     *     where mss.school_year_id = :schoolYearId
     * )
     * @param schoolYearId
     */
    //List<Subject> getAllBySchoolYearId(Long schoolYearId); (*)
    //List<Subject> getAllByMajorIdAndSchoolYearId(String majorId, Long schoolYearId) (**)

    /**
     * This method is combined from two method above
     * @param condition: condition want to filter
     * Example: In condition has pair is (key, value):
     *  in that if contains [(schoolYearId, 5), (majorId, 'CNTT')].
     *  In here have two pair -> filter like method (**) above
     * @return
     */
    List<Subject> getAllByCondition(SubjectFilterCondition subjectFilterCondition);
}
