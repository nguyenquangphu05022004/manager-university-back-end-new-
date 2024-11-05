package com.example.manageruniversity.core.major;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import com.example.manageruniversity.web.security.annotation.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.manageruniversity.common.pojo.CommonResult.*;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
public class MajorController {
    private final MajorService majorService;


    @PostMapping
    public CommonResult<MajorDto> create(@RequestBody MajorRequest majorRequest) {
        return success(new MajorDto(majorService.update(majorRequest)));
    }

    @GetMapping("/{id}")
    public CommonResult<MajorDto> getById(@PathVariable("id") String majorId) {
        return success(new MajorDto(majorService.getById(majorId)));
    }

    @GetMapping
    public PageResult<MajorDto> getAll(@RequestParam(value = "page", defaultValue = "1")int page) {
        return PageResult.success(
                majorService.getAll(page),
                (major) -> new MajorDto(major)
        );
    }

}
