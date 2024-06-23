package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.AvatarResponse;
import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.dto.TransactionDTO;
import com.example.manageruniversity.entity.Avatar;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.exception.InvalidDateException;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.RegisterMapper;
import com.example.manageruniversity.repository.*;
import com.example.manageruniversity.service.IRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.InvalidTimeoutException;
import org.springframework.transaction.annotation.Transactional;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements IRegisterService {

    private final RegisterRepository registerRepository;
    private final TransactionRepository transactionRepository;
    private final SubjectGroupRepository subjectGroupRepository;
    private final MajorRegisterRepository majorRegisterRepository;
    @Override
    @Transactional
    public RegisterDTO saveOrUpdate(RegisterDTO request) {
        if(!majorRegisterRepository.findById(request.getMajorRegisterDTO().getId())
                .orElseThrow(() -> new NotFoundIdException("MajorRegister", "Id", request.getMajorRegisterDTO().getId() + ""))
                .getOpenRegister())  {
            throw new InvalidDateException("Date for register expired");
        }
        Register register = RegisterMapper.mapper.registerDTOToEntity(request);
        SubjectGroup subjectGroup = subjectGroupRepository.findById(request.getSubjectGroup().getId())
                .orElseThrow(() -> new NotFoundIdException("SubjectGroup", "Id", request.getSubjectGroup().getId() +""));
        if (subjectGroup.getNumberOfStudent() >= subjectGroup.getNumberOfStudentCurrent()) {
            subjectGroup.setNumberOfStudentCurrent(subjectGroup.getNumberOfStudentCurrent() + 1);
            register.setSubjectGroup(subjectGroup);
            registerRepository.save(register);
            return request;
        }
        throw new RuntimeException("student quantity in class was full");
    }

    @Override
    public List<RegisterDTO> records() {
        List<Register> registers = registerRepository.findAll();
        return convertList(registers);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Register register = registerRepository.findById(id)
                .orElseThrow(() -> new NotFoundIdException("Register", "Id", id.toString()));
        SubjectGroup subjectGroup = register.getSubjectGroup();
        subjectGroup.setNumberOfStudentCurrent(subjectGroup.getNumberOfStudentCurrent() - 1 > 0 ? subjectGroup.getNumberOfStudentCurrent() - 1 : 0);
        subjectGroupRepository.save(subjectGroup);
        transactionRepository.deleteByStudentRequestIdAndTargetSubjectId(register.getStudent().getId(), register.getSubjectGroup().getSubject().getId());
        registerRepository.delete(register);
    }

    @Override
    public void transaction(Long registerId, boolean transaction) {
        Register register = registerRepository.findById(registerId)
                .orElseThrow(() -> new NotFoundIdException("Register", "Id", registerId.toString()));
        register.setOpenTransaction(transaction);
        registerRepository.save(register);
    }

    @Override
    public List<RegisterDTO> recordsByTransactionStatus(boolean transaction) {
        List<Register> registers = registerRepository.findAllByOpenTransaction(transaction);
        return convertList(registers);
    }

    @Override
    public List<RegisterDTO> getRegisterByStudentIdAndSeasonDisabled(Long studentId,
                                                                     boolean disabled) {
        List<Register> registers = registerRepository.findAllByStudentIdAndMajorRegisterSeasonDisabled(studentId, disabled);
        return convertList(registers);
    }

    @Override
    public List<RegisterDTO> findAllRegisterOpenedBySubjectIdAndNotOfStudentId(Long subjectId, Long studentId) {
        List<Register> registers = registerRepository.findAllRegisterOpenedBySubjectIdAndNotOfStudentId(subjectId, studentId);
        return convertList(registers);
    }

    public static List<RegisterDTO> convertList(List<Register> registers) {
        List<RegisterDTO> registerList = registers.stream()
                .map(register -> {
                    RegisterDTO registerDTO = RegisterMapper.mapper.registerToDTO(register);
                    Avatar avatar = register.getStudent().getUser().getAvatar();
                    if(avatar != null) {
                        AvatarResponse response = AvatarResponse.builder()
                                .fileName(avatar.getAvatarName())
                                .folderStorage(avatar.getFolderStorage())
                                .build();
                        registerDTO.getStudentDTO().getUser().setAvatarResponse(response);
                    }
                    List<TransactionDTO> transactionList = register.getListRegisterOfSubject()
                            .stream()
                            .map(registerRequest -> {
                                registerRequest.setTransactions(new ArrayList<>());
                                TransactionDTO transactionDTO = new TransactionDTO(
                                        RegisterMapper
                                                .mapper
                                                .registerToDTO(registerRequest),
                                        registerRequest.getStudent().getId());
                                return transactionDTO;
                            })
                            .collect(Collectors.toList());
                    registerDTO.setTransactionList(transactionList);
                    return registerDTO;
                }).collect(Collectors.toList());
        return registerList;
    }
}
