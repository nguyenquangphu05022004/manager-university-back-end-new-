package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.AspirationRegisterDTO;
import com.example.manageruniversity.dto.AspirationRegisterRequest;
import com.example.manageruniversity.service.IAspirationRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AspirationRegisterController {
    private final IAspirationRegisterService aspirationRegisterService;

    @PostMapping("/aspiration-register")
    public AspirationRegisterDTO createAspiration(@RequestBody AspirationRegisterRequest request) {
        return aspirationRegisterService.saveOrUpdate(request);
    }

    @GetMapping("/aspiration-register")
    public List<AspirationRegisterDTO> getListAspiration() {
        return aspirationRegisterService.records();
    }
}
