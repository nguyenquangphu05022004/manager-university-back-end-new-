package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.service.IRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class RegisterController {
    private final IRegisterService registerService;


    @PostMapping("/registers")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterDTO createRegister(
            @RequestBody RegisterDTO request
    ) {

        return registerService.saveOrUpdate(request);
    }

    @DeleteMapping("/registers/{registerId}")
    public void deleteRegister(
            @PathVariable("registerId") Long registerId
    ) {
        registerService.delete(registerId);
    }

    @GetMapping("/registers/student/{studentId}")
    public List<RegisterDTO> getRegisterListByStudentIdAndSeasonNotDisable(
            @PathVariable("studentId") Long studentId,
            @RequestParam("disabled") boolean disabled
    ) {
        return registerService
                .getRegisterByStudentIdAndSeasonDisabled(
                        studentId,
                        disabled
                );
    }

    @PutMapping("/registers/transaction/{registerId}")
    public ResponseEntity<?> transaction(
            @PathVariable("registerId") Long registerId,
            @RequestParam("transaction") boolean transaction
    ) {
        registerService.transaction(registerId, transaction);
        return ResponseEntity
                .ok("Register with Id: "
                        + registerId + " was "
                        + (transaction ? "opened" : "closed")
                        + " transaction");
    }

    @GetMapping("/registers/transaction")
    public List<RegisterDTO> registerListByTransaction(
            @RequestParam("transaction") boolean transaction
    ) {
        return registerService
                .recordsByTransactionStatus(
                        transaction
                );
    }

    @GetMapping("/registers/student/{studentId}/subject/{subjectId}")
    public List<RegisterDTO>
    getListRegisterOpenedTransactionBySubjectIdAndNotOfStudentId(
            @PathVariable("studentId") Long studentId,
            @PathVariable("subjectId") Long subjectId) {
        return registerService
                .findAllRegisterOpenedBySubjectIdAndNotOfStudentId(
                        subjectId,
                        studentId
                );
    }
}
