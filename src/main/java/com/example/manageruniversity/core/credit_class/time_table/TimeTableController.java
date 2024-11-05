package com.example.manageruniversity.core.credit_class.time_table;

import com.example.manageruniversity.common.pojo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-class/time-table")
@RequiredArgsConstructor
public class TimeTableController {
    private final TimeTableService timeTableService;

    @PostMapping
    public CommonResult<TimeTableDto> update(@RequestBody TimeTableRequest request) {
        return CommonResult.success(new TimeTableDto(timeTableService.createOrUpdate(request)));
    }


    @DeleteMapping("/{id}")
    public CommonResult<?> delete(@PathVariable("id") Long timeTableId) {
        this.timeTableService.delete(timeTableId);
        return CommonResult.success(200, "Deleted successfully", null);
    }

}
