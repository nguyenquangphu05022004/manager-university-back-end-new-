package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.RegisterDTO;

import java.util.List;

public interface IRegisterService extends IGenericService<RegisterDTO, RegisterDTO> {

    void transaction(Long registerId, boolean transaction);

    List<RegisterDTO> recordsByTransactionStatus(boolean transaction);
    List<RegisterDTO> getRegisterByStudentIdAndSeasonDisabled(Long studentId, boolean disabled);

    //method get list register opened but that not contains list register opened of student with id =studentId
    List<RegisterDTO> findAllRegisterOpenedBySubjectIdAndNotOfStudentId(Long subjectId, Long studentId);

}
