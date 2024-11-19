package com.example.manageruniversity.system.logger.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.system.logger.controller.vo.operationlogger.OperationLoggerResVO;
import com.example.manageruniversity.system.logger.service.OperationLoggerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.manageruniversity.common.pojo.CommonResult.*;

@RestController
@RequestMapping("/api/operation-logs")
@RequiredArgsConstructor
@Tag(name = "Logs")
public class OperationLoggerController {
    private final OperationLoggerService operationLoggerService;

    @GetMapping
    @Operation(summary = "Get all logs")
    public CommonResult<PageResult<OperationLoggerResVO>> getList(@RequestParam("page") int page) {
        return success(new PageResult<>(operationLoggerService.getList(page), OperationLoggerResVO::new));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete log by id")
    public CommonResult<Boolean> delete(@PathVariable("id") Long id) {
        this.operationLoggerService.delete(id);
        return success(true);
    }
}
