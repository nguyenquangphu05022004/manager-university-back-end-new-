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

    MajorRegisterDTO findByStudentIdAndSeasonNotDisabledAndOpenRegisterAndCoursesOfStudent(Long studentId, boolean openRegister, Long coursesIdOfStudent);

    MajorRegisterDTO findByStudentIdAndSeasonId(Long studentId, Long seasonId);

    List<MajorRegisterDTO> getListExtraOfStudentByStudentId(Long studentId);


}
