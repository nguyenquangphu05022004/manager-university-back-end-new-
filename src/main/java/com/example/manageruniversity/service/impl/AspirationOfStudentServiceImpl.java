package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.AspirationRequest;
import com.example.manageruniversity.dto.AspirationResponse;
import com.example.manageruniversity.entity.AspirationOfStudent;
import com.example.manageruniversity.entity.AspirationRegister;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.auth.User;
import com.example.manageruniversity.exception.InvalidDateException;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.exception.ObjectExistException;
import com.example.manageruniversity.mapper.AspirationRegisterMapper;
import com.example.manageruniversity.mapper.StudentMapper;
import com.example.manageruniversity.mapper.SubjectMapper;
import com.example.manageruniversity.repository.AspirationOfStudentRepository;
import com.example.manageruniversity.repository.AspirationRegisterRepository;
import com.example.manageruniversity.repository.SeasonRepository;
import com.example.manageruniversity.repository.SubjectRepository;
import com.example.manageruniversity.repository.auth.UserRepository;
import com.example.manageruniversity.service.IAspirationOfStudentService;
import com.example.manageruniversity.utils.SystemUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AspirationOfStudentServiceImpl implements IAspirationOfStudentService {
    private final AspirationOfStudentRepository aspirationOfStudentRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final SeasonRepository seasonRepository;
    private final AspirationRegisterRepository aspirationRegisterRepository;

    @Override
    public AspirationResponse saveOrUpdate(AspirationRequest aspirationRequest) {
        User user = userRepository.findByUsername(SystemUtils.getUsername())
                .orElseThrow(() -> new NotFoundIdException("User", "Username",
                        SystemUtils.getUsername()));

        Subject subject = subjectRepository.findBySubjectCode(aspirationRequest.getSubjectCode())
                .orElseThrow(() -> new NotFoundIdException("Subject", "SubjectCode",
                        aspirationRequest.getSubjectCode()));
        AspirationRegister aspirationRegister = aspirationRegisterRepository
                .findById(aspirationRequest.getAspirationRegisterId())
                .orElseThrow(() -> new NotFoundIdException(
                        "ASPIRATION_REGISTER",
                        "ID",
                        aspirationRequest.getAspirationRegisterId()
                ));
        if (aspirationOfStudentRepository.findByStudentIdAndAspirationRegisterIdAndSubjectId(
                user.getStudent().getId(),
                aspirationRequest.getAspirationRegisterId(),
                subject.getId()
        ).isPresent()) {
            throw new ObjectExistException("Aspiration was exist");
        }
        if (!aspirationRegister.getOpenRegister()) {
            throw new InvalidDateException("Aspiration register expired");
        }
        AspirationOfStudent aspirationOfStudent = new AspirationOfStudent(
                user.getStudent(),
                subject,
                aspirationRegister,
                false);
        AspirationOfStudent saved = aspirationOfStudentRepository.save(aspirationOfStudent);
        return getToDto(saved);
    }

    @Override
    public List<AspirationResponse> records() {
        return aspirationOfStudentRepository.findAll()
                .stream()
                .map(this::getToDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        aspirationOfStudentRepository.deleteById(id);
    }

    private AspirationResponse getToDto(AspirationOfStudent aspirationOfStudent) {
        AspirationResponse response = AspirationResponse.builder()
                .subject(SubjectMapper.mapper
                        .subjectToDTO(aspirationOfStudent.getSubject()))
                .student(StudentMapper.mapper
                        .studentToDTO(aspirationOfStudent.getStudent()))
                .aspirationRegister(AspirationRegisterMapper.mapper
                        .mapToDto(aspirationOfStudent.getAspirationRegister()))
                .approval(aspirationOfStudent.isApproval())
                .build();
        response.setId(aspirationOfStudent.getId());
        return response;

    }

    @Override
    public List<AspirationResponse> getListAspirationByStudentIdAndAspirationRegisterId(
            Long studentId,
            Long aspirationRegisterId
    ) {
        List<AspirationResponse> listResponseByStudent = aspirationOfStudentRepository
                .findAllByStudentIdAndAspirationRegisterId(
                        studentId,
                        aspirationRegisterId
                )
                .stream()
                .map(this::getToDto)
                .toList();
        return listResponseByStudent;
    }

    @Override
    @Transactional
    public void approvalAspirationRegisterOfStudent(
            Long subjectId,
            Long aspirationRegisterId) {
        List<AspirationOfStudent> aspirationOfStudents =
                aspirationOfStudentRepository
                        .findAllByAspirationRegisterIdAndSubjectId(
                                aspirationRegisterId,
                                subjectId
                        );
        aspirationOfStudents.
                stream()
                .forEach(e -> {
                    e.setApproval(true);
                    aspirationOfStudentRepository.save(e);
                });
    }
}
