package com.example.manageruniversity.university.major;

import com.example.manageruniversity.common.pojo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MajorController {
    private final MajorService majorService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('major:create')")
    public CommonResult<MajorDto> create(@RequestBody MajorRequest majorRequest) {
        return success(new MajorDto(majorService.update(majorRequest)));
    }

    @GetMapping("/{id}")
    public CommonResult<MajorDto> getById(@PathVariable("id") String majorId) {
        return success(new MajorDto(majorService.getById(majorId)));
    }

    @GetMapping
    public CommonResult<List<MajorDto>> getAll() {
        return CommonResult.success(majorService.getAll(),MajorDto::new);
    }

}
