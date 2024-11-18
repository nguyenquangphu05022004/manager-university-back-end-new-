package com.example.manageruniversity.university.score.controller;


import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.KeyPair;
import com.example.manageruniversity.security.utils.SecurityUtils;
import com.example.manageruniversity.university.school_year.SchoolYearDto;
import com.example.manageruniversity.university.score.controller.vo.ScoreResVO;
import com.example.manageruniversity.university.score.dal.entity.Score;
import com.example.manageruniversity.university.score.service.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.manageruniversity.common.collection.ListUtils.convertToList;
import static com.example.manageruniversity.common.collection.MapUtils.convertToMap;
import static com.example.manageruniversity.common.pojo.CommonResult.success;

@RestController
@RequiredArgsConstructor
@Tag(name = "Score - Diem cua sinh vien")
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @Operation(summary = "Khoi tao diem cho sinh vien",
    description = "Khoi tao diem cho sinh vien theo hoc ky ma nhung sinh vien dang hoc")
    @PostMapping("/school-year/{schoolYearId}")
    @PreAuthorize("@ss.hasPermission('score:init')")
    public CommonResult<?> init(@PathVariable("schoolYearId") Long schoolYearId) {
        this.scoreService.initForAllStudentBySchoolYearId(schoolYearId);
        return success("Init success");
    }


    @GetMapping("/students")
    @Operation(summary = "Lay toan bo diem cua diem sinh vien", description = "Lay toan bo diem boi chinh nhung sinh vien do")
    @PreAuthorize("@ss.hasPermission('score:students')")
    public CommonResult<Map<SchoolYearDto, List<ScoreResVO>>> getAllByStudent() {
        List<Score> scores = this.scoreService.getAllByStudentId(SecurityUtils.getLoginUserId());
        Map<SchoolYearDto, List<ScoreResVO>> response = convertToMap(convertToList(scores, (score) -> new KeyPair<>(new SchoolYearDto(score.getSchoolYear()), new ScoreResVO(score))));
        return success(response);
    }




}
