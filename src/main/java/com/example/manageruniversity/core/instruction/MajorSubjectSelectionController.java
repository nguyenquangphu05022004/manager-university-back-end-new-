package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.filter.Condition;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/major-subject-selection")
public class MajorSubjectSelectionController {
    private final MajorSubjectSelectionService majorSubjectSelectionService;

    @PostMapping
    public CommonResult<MajorSubjectSelectionDto> update(MajorSubjectSelectionRequest request) {
        return success(new MajorSubjectSelectionDto(majorSubjectSelectionService.create(request)));
    }

    @GetMapping("/get-all-by-condition")
    public CommonResult<List<MajorSubjectSelectionDto>> getAllByCondition(@RequestBody Condition condition) {
        return success(
                majorSubjectSelectionService.findAllByCondition(condition),
                MajorSubjectSelectionDto::new
        );
    }

    @DeleteMapping("/{id}")
    public CommonResult<?> delete(@PathVariable("id") Long id) {
        this.majorSubjectSelectionService.delete(id);
        return success(200, "Deleted success", null);
    }
}
