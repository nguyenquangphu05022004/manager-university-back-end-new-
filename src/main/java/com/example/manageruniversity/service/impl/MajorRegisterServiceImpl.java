package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.PaymentResponse;
import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.entity.*;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.MajorRegisterMapper;
import com.example.manageruniversity.mapper.RegisterMapper;
import com.example.manageruniversity.mapper.SeasonMapper;
import com.example.manageruniversity.repository.MajorRegisterRepository;
import com.example.manageruniversity.repository.PaymentRepository;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.service.IMajorRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorRegisterServiceImpl implements IMajorRegisterService {
    private final MajorRegisterRepository majorRegisterRepository;
    private final RegisterRepository registerRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public MajorRegisterDTO saveOrUpdate(MajorRegisterDTO majorRegisterDTO) {
        MajorRegister majorRegister = majorRegisterRepository
                .findBySeasonIdAndMajorId(majorRegisterDTO.getSeasonDTO().getId(),
                majorRegisterDTO.getMajorDTO().getId());
        if(majorRegister != null) {
            List<Subject> subjects = majorRegister.getSubjects();
            for(var s : majorRegisterDTO.getSubjectDTOS()) {
                Subject subject = new Subject(); subject.setId(s.getId());
                int index = checkSubjectIdIsExistsInList(subjects, s.getId(), 0, subjects.size() - 1);
                if(index >= 0) {
                    subjects.add(subject);
                }
            }
        } else {
            majorRegister = MajorRegisterMapper.mapper.majorRegisterDTOToEntity(majorRegisterDTO);
        }
         majorRegisterRepository.save(majorRegister);
        return null;
    }

    private int checkSubjectIdIsExistsInList(List<Subject> subjects, Long id, int l, int r) {
        int x = l;
        int y = r;
        while(x < y) {
            int mid = (x + y) /2;
            if(subjects.get(mid).getId() > id) {
                y = mid - 1;
            } else if(subjects.get(mid).getId() < id) {
                x = mid + 1;
            } else {
                return mid;
            }
        }
        return -(l + r);
    }

    @Override
    public List<MajorRegisterDTO> records() {
        List<MajorRegister> majorRegisters = majorRegisterRepository.findAll();
        return majorRegisters.stream().map(majorRegister -> {
            MajorRegisterDTO majorRegisterDTO = MajorRegisterMapper.mapper
                    .majorRegisterToDTO(majorRegister);
            var re = majorRegister.getSeason(); re.setMajorRegisters(new ArrayList<>());
            majorRegisterDTO.setSeasonDTO(SeasonMapper.mapper.seasonToDTO(re));
            return majorRegisterDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        majorRegisterRepository.deleteById(id);
    }

    @Override
    public MajorRegisterDTO findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled) {
        MajorRegister majorRegister = majorRegisterRepository.findByMajorIdAndSeasonDisabled(majorId, disabled);
        return MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
    }

    @Override
    public List<MajorRegisterDTO> findAllByStudentIdAndCoursesId(Long studentId, Long coursesId) {
        List<MajorRegister> majorRegisters = majorRegisterRepository.findAllByStudentIdAndCoursesId(studentId, coursesId);
        for(MajorRegister m : majorRegisters) {
            List<Register> registers = registerRepository.findAllByStudentIdAndMajorRegisterId(studentId, m.getId());
            m.setRegisters(registers);
        }
         return majorRegisters.stream()
                .map(majorRegister -> {

                    MajorRegisterDTO majorResponse = MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
                    Optional<Payment> payment = paymentRepository.findByStudentIdAndMajorRegisterId(studentId, majorRegister.getId());
                    if(payment.isPresent()) {
                        PaymentResponse paymentResponse = PaymentResponse.builder()
                                .description(payment.get().getDescription())
                                .amountPaid(payment.get().getAmountPaid())
                                .transactionId(payment.get().getTransactionId())
                                .complete(payment.get().getComplete())
                                .build();
                        majorResponse.setPaymentOfPerStudentAtCurrentSeason(paymentResponse);
                    }
                    return majorResponse;
                })
                .toList();
    }

    @Override
    public MajorRegisterDTO findByStudentIdAndSeasonNotDisabledAndOpenRegisterAndCoursesOfStudent(Long studentId, boolean openRegister, Long coursesIdOfStudent) {
        MajorRegister majorRegister = majorRegisterRepository.findByStudentIdAndSeasonNotDisabledAndOpenRegisterAndCoursesOfStudent(studentId, openRegister,coursesIdOfStudent)
                .orElseThrow(() -> new NotFoundIdException("MajorRegister", "StudentId - OpenRegister", studentId + " - " + openRegister));
        List<RegisterDTO> list = registerRepository.findAllByStudentIdAndMajorRegisterId(studentId, majorRegister.getId())
                .stream().map(e -> RegisterMapper.mapper.registerToDTO(e))
                .toList();
        MajorRegisterDTO majorRegisterDTO = MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
        majorRegisterDTO.setRegisterDTOS(list);
        return majorRegisterDTO;
    }

    @Override
    public MajorRegisterDTO findByStudentIdAndSeasonId(Long studentId, Long seasonId) {
        Optional<MajorRegister> optional = majorRegisterRepository.findByStudentIdAndSeasonId(studentId, seasonId);
        if(optional.isEmpty()) {
            optional = majorRegisterRepository.findByStudentIdAndSeasonIdExtra(studentId, seasonId);
        }
        var majorRegister = optional.orElseThrow(()     -> new NotFoundIdException("MajorRegister", "Student-Season", studentId + " - " + seasonId));
        List<RegisterDTO> list = registerRepository.findAllByStudentIdAndMajorRegisterId(studentId, majorRegister.getId())
                .stream().map(e -> RegisterMapper.mapper.registerToDTO(e))
                .toList();
        MajorRegisterDTO majorRegisterDTO = MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
        majorRegisterDTO.setRegisterDTOS(list);
        return majorRegisterDTO;
    }
}
