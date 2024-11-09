package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.filter.Condition;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/major-subject-selection")
@CrossOrigin("*")
public class MajorSubjectSelectionController {
    private final MajorSubjectSelectionService majorSubjectSelectionService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('major-selection-subject:create-update')")
    public CommonResult<MajorSubjectSelectionDto> createOrUpdate(@RequestBody MajorSubjectSelectionRequest request) {
        return success(new MajorSubjectSelectionDto(majorSubjectSelectionService.create(request)));
    }

    @GetMapping()
    public CommonResult<List<MajorSubjectSelectionDto>> getAll() {
        return success(majorSubjectSelectionService.getAll(), MajorSubjectSelectionDto::new);
    }

    @GetMapping("/get-all-by-condition")
    public CommonResult<List<MajorSubjectSelectionDto>> getAllByCondition(@RequestBody Condition condition) {
        return success(
                majorSubjectSelectionService.findAllByCondition(condition),
                MajorSubjectSelectionDto::new
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('major-selection-subject:delete')")
    public CommonResult<?> delete(@PathVariable("id") Long id) {
        this.majorSubjectSelectionService.delete(id);
        return success("Deleted success");
    }
}
