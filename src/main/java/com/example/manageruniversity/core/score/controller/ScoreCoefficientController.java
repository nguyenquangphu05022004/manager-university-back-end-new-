package com.example.manageruniversity.core.score.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.common.pojo.KeyPair;
import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.score.controller.vo.ScoreCoefficientReqVO;
import com.example.manageruniversity.core.score.controller.vo.ScoreCoefficientResVO;
import com.example.manageruniversity.core.score.dal.entity.ScoreCoefficient;
import com.example.manageruniversity.core.score.service.ScoreCoefficientService;
import com.example.manageruniversity.core.subject.SubjectDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.example.manageruniversity.common.collection.CollUtils.convertToSet;
import static com.example.manageruniversity.common.collection.ListUtils.convertToList;
import static com.example.manageruniversity.common.collection.MapUtils.convertToMap;
import static com.example.manageruniversity.common.pojo.CommonResult.success;

@Tag(name = "Score Coefficient - Trong so diem cua mon hoc")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/score-coefficient")
public class ScoreCoefficientController {


    private final ScoreCoefficientService scoreCoefficientService;


    @PostMapping
    @Operation(summary = "Tao trong so diem thanh phan cho tung mon hoc")
    @PreAuthorize("@ss.hasPermission('score-coefficient:create')")
    public CommonResult<?> create(@RequestBody @Valid ScoreCoefficientReqVO scoreCoefficientReqVO) {
        this.scoreCoefficientService.create(scoreCoefficientReqVO);
        return success("created successfully");
    }


    @GetMapping
    @Operation(summary = "Lay toan bo danh sach trong so diem thanh phan mon hoc")
    @PreAuthorize("@ss.hasPermission('score-coefficient:get')")
    public CommonResult<Map<SchoolYearDto, Map<SubjectDto, List<ScoreCoefficientResVO>>>> getList() {
        List<ScoreCoefficient> scoreCoefficients = scoreCoefficientService.getList();

        Set<KeyPair<SchoolYearDto, Map<SubjectDto, List<ScoreCoefficientResVO>>>> keyPairs = convertToSet(scoreCoefficients, s -> {
            return new KeyPair<>(
                    new SchoolYearDto(s.getSchoolYear()),
                    convertToMap(convertToList(
                            scoreCoefficients,
                            fSub -> {
                                if (fSub.getSchoolYear().equals(s.getSchoolYear())) {
                                    return new KeyPair<>(new SubjectDto(fSub.getSubject()), new ScoreCoefficientResVO(fSub));
                                }
                                return null;
                            }
                    ))
            );
        });
        return success(convertToMap(keyPairs));
    }


    @GetMapping("/school-year/{schoolYearId}/subject/{subjectId}")
    @Operation(summary = "Lay toan bo he so cua mon hoc, de tinh diem mon hoc do cho sinh vien")
    public CommonResult<List<ScoreCoefficientResVO>> getListBySchoolAndSubject(
            @PathVariable("schoolYearId") Long schoolYearId,
            @PathVariable("subjectId") String subjectId
    ) {
        return success(
                this.scoreCoefficientService.getListBySchoolYearIdAndSubjectId(schoolYearId, subjectId),
                ScoreCoefficientResVO::new
        );
    }
}


