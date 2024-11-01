package com.example.manageruniversity.exam.controller;

import com.example.manageruniversity.exam.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
}
