package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.EventRegisterRequest;
import com.example.manageruniversity.dto.EventRegisterResponse;
import com.example.manageruniversity.service.IEventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EventRegisterController {
    private final IEventRegisterService eventRegisterService;

    @PostMapping("/events")
    public void createEventRegister(@RequestBody EventRegisterRequest eventRegisterRequest) {
        eventRegisterService.saveOrUpdate(eventRegisterRequest);
    }
    @GetMapping("/events")
    public List<EventRegisterResponse> getListEventRegister()  {
        return eventRegisterService.records();
    }
}
