package com.example.manageruniversity.core.credit_class.time_table;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-class/time-table")
@RequiredArgsConstructor
public class TimeTableController {
    private final TimeTableService timeTableService;
}
