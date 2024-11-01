package com.example.manageruniversity.core.subject.service;

import com.example.manageruniversity.core.instruction.domain.entity.MajorSubjectSelection;
import com.example.manageruniversity.core.subject.domain.dto.SubjectDto;
import com.example.manageruniversity.core.subject.domain.entity.Subject;
import com.example.manageruniversity.core.subject.domain.request.SubjectFilterCondition;
import com.example.manageruniversity.filter.Condition;
import com.example.manageruniversity.filter.SubQueryCondition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Override
    public Subject create(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public List<Subject> getAll() {
        return null;
    }

    @Override
    public Subject getById(String subjectId) {
        return null;
    }

    @Override
    public List<Subject> getAllByCondition(SubjectFilterCondition subjectFilterCondition) {
        Condition condition = new Condition();
        for(var field : subjectFilterCondition.getClass().getDeclaredFields()) {
            field.canAccess(true);
            try {
                SubQueryCondition subQueryCondition = new SubQueryCondition(
                        String.class,
                        "subjectId",
                        MajorSubjectSelection.class,
                        "majorId",
                        (String)field.get(subjectFilterCondition)
                );
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
