package com.example.manageruniversity.core.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;

    @Override
    public Subject create(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public List<Subject> getAll() {
        return this.subjectRepository.findAll();
    }

    @Override
    public Subject getById(String subjectId) {
        return null;
    }


    @Override
    public List<Subject> getAllByMajorIdAndSchoolYearIdAndCourseId(
            String majorId, Long schoolYearId,
            String courseId) {
        return null;
    }


//    @Override
//    @SuppressWarnings("test")
//    public List<Subject> getAllByCondition(SubjectFilterCondition subjectFilterCondition) {
//        Condition condition = new Condition();
//        for(var field : subjectFilterCondition.getClass().getDeclaredFields()) {
//            field.canAccess(true);
//            try {
//                SubQueryCondition subQueryCondition = new SubQueryCondition(
//                        String.class,
//                        "subjectId",
//                        MajorSubjectSelection.class,
//                        "majorId",
//                        (String)field.get(subjectFilterCondition)
//                );
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return null;
//    }
}
