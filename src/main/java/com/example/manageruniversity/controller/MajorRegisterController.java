package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.service.IMajorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class MajorRegisterController {
    private final IMajorRegisterService majorRegisterService;

    @Autowired
    public MajorRegisterController(IMajorRegisterService majorRegisterService) {
        this.majorRegisterService = majorRegisterService;
    }

    @PostMapping("/majorRegisters")
    public MajorRegisterDTO createMajorRegister(@RequestBody MajorRegisterDTO majorRegisterDTO) {
        return majorRegisterService.saveOrUpdate(majorRegisterDTO);
    }

    @PutMapping("/majorRegisters/{majorRegisterId}")
    public MajorRegisterDTO createMajorRegister(@RequestBody MajorRegisterDTO majorRegisterDTO,
                                                @PathVariable("majorRegisterId") Long majorRegisterId) {
        return majorRegisterService.saveOrUpdate(majorRegisterDTO);
    }

    @DeleteMapping("/api/majorRegisters/{majorRegisterId}")
    public void deleteMajorRegister(@PathVariable("majorRegisterId") Long majorRegisterId) {
        majorRegisterService.delete(majorRegisterId);
    }

    @GetMapping("/majorRegisters")
    public List<MajorRegisterDTO> majorRegisterList() {
        return majorRegisterService.records();
    }

    @GetMapping("/majorRegisters/major/{majorId}")
    public MajorRegisterDTO getByMajorIdAndSeasonDisabledIsFalse(@PathVariable("majorId") Long majorId, @RequestParam("disabled") boolean disabled) {
        return majorRegisterService.findByMajorIdAndSeasonDisabled(majorId, disabled);
    }

    @GetMapping("/majorRegisters/list/student/{studentId}/courses/{coursesId}")
    public List<MajorRegisterDTO> getListByStudentIdAndCoursesId(@PathVariable("studentId") Long studentId,
                                                                 @PathVariable("coursesId") Long coursesId) {
        return majorRegisterService.findAllByStudentIdAndCoursesId(studentId, coursesId);
    }

    @GetMapping("/majorRegisters/student/{studentId}")
    public MajorRegisterDTO getByStudentIdAndSeasonWithOpenRegister(@PathVariable("studentId") Long studentId,
                                                                    @RequestParam("openRegister") boolean openRegister,
                                                                    @RequestParam("coursesIdOfStudent") Long coursesIdOfStudent) {
        return majorRegisterService.findByStudentIdAndSeasonNotDisabledAndOpenRegisterAndCoursesOfStudent(studentId, openRegister, coursesIdOfStudent);
    }

    @GetMapping("/majorRegisters/student/{studentId}/season/{seasonId}")
    public MajorRegisterDTO getByStudentIdAndSeasonId(@PathVariable("studentId") Long studentId,
                                                      @PathVariable("seasonId") Long seasonId) {
        return majorRegisterService.findByStudentIdAndSeasonId(studentId, seasonId);
    }


    /*
        this method get all list season extra student registered
     */
    @GetMapping("/majorRegisters/extra/student/{studentId}")
    public List<MajorRegisterDTO> getListExtraOfStudent(@PathVariable("studentId") Long studentId) {
        return majorRegisterService.getListExtraOfStudentByStudentId(studentId);
    }
}
