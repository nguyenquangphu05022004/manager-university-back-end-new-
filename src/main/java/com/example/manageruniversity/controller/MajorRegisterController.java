package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.service.IMajorRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MajorRegisterController {
    private final IMajorRegisterService majorRegisterService;
    @PostMapping("/majorRegisters")
    public MajorRegisterDTO createMajorRegister(
            @RequestBody MajorRegisterDTO majorRegisterDTO) {
        return majorRegisterService
                .saveOrUpdate(
                        majorRegisterDTO
                );
    }

    @DeleteMapping("/api/majorRegisters/{majorRegisterId}")
    public void deleteMajorRegister(
            @PathVariable("majorRegisterId") Long majorRegisterId) {
        majorRegisterService.delete(majorRegisterId);
    }

    @GetMapping("/majorRegisters")
    public List<MajorRegisterDTO> majorRegisterList() {
        return majorRegisterService.records();
    }

    @GetMapping("/majorRegisters/major/{majorId}")
    public MajorRegisterDTO getByMajorIdAndSeasonDisabledIsFalse(
            @PathVariable("majorId") Long majorId,
            @RequestParam("disabled") boolean disabled
    ) {
        return majorRegisterService.
                findByMajorIdAndSeasonDisabled(
                        majorId,
                        disabled
                );
    }

    @GetMapping("/majorRegisters/list/student/{studentId}/courses/{coursesId}")
    public List<MajorRegisterDTO> getListByStudentIdAndCoursesId(
            @PathVariable("studentId") Long studentId,
            @PathVariable("coursesId") Long coursesId
    ) {
        return majorRegisterService
                .findAllByStudentIdAndCoursesId(
                        studentId,
                        coursesId
                );
    }

    @GetMapping("/majorRegisters/student/{studentId}/season/{seasonId}")
    public MajorRegisterDTO getByStudentIdAndSeasonId(
            @PathVariable("studentId") Long studentId,
            @PathVariable("seasonId") Long seasonId
    ) {
        return majorRegisterService
                .findByStudentIdAndSeasonId(
                        studentId,
                        seasonId
                );
    }

    @GetMapping("/majorRegisters/extra/student/{studentId}")
    public List<MajorRegisterDTO> getListExtraOfStudent(
            @PathVariable("studentId") Long studentId
    ) {
        return majorRegisterService
                .getListExtraOfStudentByStudentId(
                        studentId
                );
    }

    @PutMapping("/majorRegisters/{majorRegisterId}/subject/{subjectId}")
    public void updateSubjectInMajorRegister(
            @RequestParam("actionType") boolean actionType,
            @PathVariable("majorRegisterId") Long majorRegisterId,
            @PathVariable("subjectId") Long subjectId
    ) {
        majorRegisterService
                .updateSubject(
                        actionType,
                        majorRegisterId,
                        subjectId
                );
    }
}
