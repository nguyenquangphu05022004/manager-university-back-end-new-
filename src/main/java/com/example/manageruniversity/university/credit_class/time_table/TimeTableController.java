package com.example.manageruniversity.university.credit_class.time_table;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.university.credit_class.time_table.vo.TimeTableCreateReqVO;
import com.example.manageruniversity.university.credit_class.time_table.vo.TimeTableResVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-table")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TimeTableController {
    private final TimeTableService timeTableService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('time-table:create')")
    public CommonResult<TimeTableResVO> create(@Valid @RequestBody TimeTableCreateReqVO request) {
        return CommonResult.success(new TimeTableResVO(timeTableService.create(request)));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('time-table:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long timeTableId) {
        this.timeTableService.delete(timeTableId);
        return CommonResult.success(200, "Deleted successfully", null);
    }

    @GetMapping("/credit-class/{creditClassId}")
    public CommonResult<List<TimeTableResVO>> getAllByCreditClass(@PathVariable("creditClassId") Long creditClassId) {
        return CommonResult.success(ListUtils.convertToList(timeTableService.getAllByCreditClassId(creditClassId), TimeTableResVO::new));
    }

}
