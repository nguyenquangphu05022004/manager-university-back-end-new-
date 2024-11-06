package com.example.manageruniversity.core.school_year;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.manageruniversity.common.pojo.CommonResult.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school-year")
public class SchoolYearController {
    private final SchoolYearService schoolYearService;


    public CommonResult<SchoolYearDto> update(@RequestBody SchoolYearRequest request) {
        return success(new SchoolYearDto(schoolYearService.update(request)));
    }

    @GetMapping("/get-all-by-couse-id-{courseId}")
    public CommonResult<List<SchoolYearDto>> getAllByCourseId(@PathVariable("courseId") String courseId) {
        return success(schoolYearService.getAllByCourseId(courseId), SchoolYearDto::new);
    }

}
