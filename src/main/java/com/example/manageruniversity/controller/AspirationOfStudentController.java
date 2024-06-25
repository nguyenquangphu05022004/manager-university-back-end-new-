package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.AspirationRequest;
import com.example.manageruniversity.dto.AspirationResponse;
import com.example.manageruniversity.service.IAspirationOfStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AspirationOfStudentController {
    private final IAspirationOfStudentService aspirationOfStudentService;

    @PostMapping("/aspirations")
    public AspirationResponse createAspiration(
            @RequestBody AspirationRequest aspirationRequest
    ) {
        return aspirationOfStudentService
                .saveOrUpdate(aspirationRequest);
    }

    @GetMapping("/aspirations")
    public List<AspirationResponse> getListAspiration() {
        return aspirationOfStudentService.records();
    }
    @GetMapping("/aspirations/student/{studentId}/aspiration-register/{aspirationRegisterId}")
    public List<AspirationResponse> getListByAspirationRegisterIdAndStudentId(
            @PathVariable("studentId") Long studentId,
            @PathVariable("aspirationRegisterId") Long aspirationRegisterId
    ) {
        return aspirationOfStudentService
                .getListAspirationByStudentIdAndAspirationRegisterId(
                        studentId,
                        aspirationRegisterId
                );
    }
    @DeleteMapping("/aspirations/{aspirationId}")
    public void deleteAspiration(@PathVariable("aspirationId") Long aspiration) {
         aspirationOfStudentService.delete(aspiration);
    }
    @PutMapping("/aspirations/approval")
    public void approvalAspirationOfStudent(
            @RequestParam("subjectId") Long subjectId,
            @RequestParam("aspirationRegisterId") Long aspirationRegisterId
    ) {
        aspirationOfStudentService.approvalAspirationRegisterOfStudent(
                subjectId,
                aspirationRegisterId
        );
    }
}
