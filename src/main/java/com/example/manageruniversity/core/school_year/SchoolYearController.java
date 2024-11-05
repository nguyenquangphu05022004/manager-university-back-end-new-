package com.example.manageruniversity.core.school_year;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school-year")
public class SchoolYearController {
    private final SchoolYearService schoolYearService;


    public CommonResult<SchoolYearDto> update(@RequestBody SchoolYearRequest request) {
        return CommonResult.success(new SchoolYearDto(schoolYearService.update(request)));
    }

    @GetMapping("/get-all-by-couse-id-{courseId}")
    public PageResult<SchoolYearDto> getAllByCourseId(@PathVariable("courseId") String courseId,
                                                      @RequestParam(value = "page", defaultValue = "1") int page) {
        return PageResult.success(
                schoolYearService.getAllByCourseId(courseId, page),
                s -> new SchoolYearDto(s)
        );
    }

}
