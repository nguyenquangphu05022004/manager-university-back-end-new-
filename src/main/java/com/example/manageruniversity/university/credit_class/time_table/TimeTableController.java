package com.example.manageruniversity.university.credit_class.time_table;

import com.example.manageruniversity.common.pojo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-class/time-table")
@RequiredArgsConstructor
public class TimeTableController {
    private final TimeTableService timeTableService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('time-table:create')")
    public CommonResult<TimeTableDto> create(@RequestBody TimeTableRequest request) {
        return CommonResult.success(new TimeTableDto(timeTableService.createOrUpdate(request)));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('time-table:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long timeTableId) {
        this.timeTableService.delete(timeTableId);
        return CommonResult.success(200, "Deleted successfully", null);
    }

}
