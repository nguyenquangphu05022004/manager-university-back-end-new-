package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;

import java.util.List;

public interface ISubjectGroupService extends IGenericService<SubjectGroupDTO,SubjectGroupDTO> {
    List<SubjectGroupDTO> findAllBySubjectId(Long subjectId);

    void updateTeacher(Long subjectGroupId, String teacherCode);
}
