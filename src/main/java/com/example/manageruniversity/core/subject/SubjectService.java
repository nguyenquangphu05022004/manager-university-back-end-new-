package com.example.manageruniversity.core.subject;

public interface SubjectService {
    void create();
    void update();
    void getAll();
    void getBySubjectId(String subjectId);

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
    void getAllBySchoolYearId(Long schoolYearId);

}
