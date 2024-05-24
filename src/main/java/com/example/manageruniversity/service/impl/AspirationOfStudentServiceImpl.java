package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.AspirationRequest;
import com.example.manageruniversity.dto.AspirationResponse;
import com.example.manageruniversity.entity.AspirationOfStudent;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.auth.User;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.StudentMapper;
import com.example.manageruniversity.mapper.SubjectMapper;
import com.example.manageruniversity.repository.AspirationOfStudentRepository;
import com.example.manageruniversity.repository.SeasonRepository;
import com.example.manageruniversity.repository.SubjectRepository;
import com.example.manageruniversity.repository.auth.UserRepository;
import com.example.manageruniversity.service.IAspirationOfStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AspirationOfStudentServiceImpl implements IAspirationOfStudentService {
    private final AspirationOfStudentRepository aspirationOfStudentRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final SeasonRepository seasonRepository;
    @Override
    public AspirationResponse saveOrUpdate(AspirationRequest aspirationRequest) {
        User user = userRepository.findByUsername(aspirationRequest.getStudentCode())
                .orElseThrow(() -> new NotFoundIdException("User", "Username",
                        aspirationRequest.getStudentCode()));

        Subject subject = subjectRepository.findBySubjectCode(aspirationRequest.getSubjectCode())
                .orElseThrow(() -> new NotFoundIdException("Subject", "SubjectCode",
                        aspirationRequest.getSubjectCode()));
        Season season = seasonRepository.findById(aspirationRequest.getSeasonId())
                .orElseThrow(() -> new NotFoundIdException("Season", "Id", aspirationRequest.getSeasonId()));
        AspirationOfStudent aspirationOfStudent = new AspirationOfStudent(user.getStudent(), subject, season, false);
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
                .subject(SubjectMapper.mapper.subjectToDTO(aspirationOfStudent.getSubject()))
                .student(StudentMapper.mapper.studentToDTO(aspirationOfStudent.getStudent()))
                .build();
        response.setId(aspirationOfStudent.getId());
        return response;

    }

    @Override
    public List<AspirationResponse> getListAspirationByStudentId(Long studentId) {
        List<AspirationResponse> listResponseByStudent = aspirationOfStudentRepository
                .findAllByStudentId(studentId)
                .stream()
                .map(this::getToDto)
                .toList();
        return listResponseByStudent;
    }
}
