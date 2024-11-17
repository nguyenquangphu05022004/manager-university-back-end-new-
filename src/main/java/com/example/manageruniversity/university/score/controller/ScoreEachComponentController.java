package com.example.manageruniversity.university.score.controller;

import com.example.manageruniversity.common.pojo.CommonResult;
import com.example.manageruniversity.university.score.controller.vo.ScoringEachComponentReqVO;
import com.example.manageruniversity.university.score.controller.vo.ScoringEachComponentResVO;
import com.example.manageruniversity.university.score.service.ScoringEachComponentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/score-each-component")
public class ScoreEachComponentController {

    private final ScoringEachComponentService scoringEachComponentService;

    @PostMapping
    @PreAuthorize("@ss.hasPermission('score-each-component:create')")
    public CommonResult<ScoringEachComponentResVO> addScoreComponent(@Valid @RequestBody ScoringEachComponentReqVO req) {
        return CommonResult.success(new ScoringEachComponentResVO(this.scoringEachComponentService.create(req)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("@ss.hasPermission('score-each-component:update')")
    public CommonResult<ScoringEachComponentResVO> update(@PathVariable("id") Long uId, @Valid @RequestBody ScoringEachComponentReqVO req) {
        return CommonResult.success(new ScoringEachComponentResVO(this.scoringEachComponentService.update(uId, req)));
    }



}
