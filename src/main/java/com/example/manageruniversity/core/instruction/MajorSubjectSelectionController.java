package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.filter.Condition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/major-subject-selection")
public class MajorSubjectSelectionController {
    private final MajorSubjectSelectionService majorSubjectSelectionService;

    @PostMapping
    public CommonResult<MajorSubjectSelectionDto> update(MajorSubjectSelectionRequest request) {
        return CommonResult.success(new MajorSubjectSelectionDto(majorSubjectSelectionService.create(request)));
    }

    @GetMapping("/get-all-by-condition")
    public PageResult<MajorSubjectSelectionDto> getAllByCondition(@RequestBody Condition condition,
                                                                  @RequestParam(value = "page", defaultValue = "1") int page) {
        return PageResult.success(
                majorSubjectSelectionService.findAllByCondition(condition, page),
                s -> new MajorSubjectSelectionDto(s)
        );
    }

    @DeleteMapping("/{id}")
    public CommonResult<?> delete(@PathVariable("id") Long id) {
        this.majorSubjectSelectionService.delete(id);
        return CommonResult.success(200, "Deleted success", null);
    }
}
