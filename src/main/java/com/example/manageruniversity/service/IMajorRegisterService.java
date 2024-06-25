package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.MajorRegisterDTO;

import java.util.List;

public interface IMajorRegisterService extends IGenericService<MajorRegisterDTO, MajorRegisterDTO> {
    /**
     * Season disabled -> after day register subject expired disabled: true
     * else disabled: false
     */
    MajorRegisterDTO findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled); //isBlock default false

    List<MajorRegisterDTO> findAllByStudentIdAndCoursesId(Long studentId, Long coursesId);
    /**
     *
     * @param studentId
     * @param seasonId
     * @return:  MajorRegister includes list subject for student Register
     * Every student have a major and student only register the subjects
     * that in MajorRegister
     * Imagine MajorRegister like Semester at College
     */
    MajorRegisterDTO findByStudentIdAndSeasonId(Long studentId, Long seasonId);

    /**
     *
     * @param studentId
     * @return: list extra season that student
     * registered at aspiration register of student
     */
    List<MajorRegisterDTO> getListExtraOfStudentByStudentId(Long studentId);

    /**
     *
     * @param typeAction: typeAction is true =>
     *                  add subject into MajorRegister
     *                  else remove subject from MajorRegister
     * @param majorRegisterId
     */
    void updateSubject(boolean typeAction,
                       Long majorRegisterId,
                       Long subjectId);

}
