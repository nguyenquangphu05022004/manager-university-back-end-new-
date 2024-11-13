package com.example.manageruniversity.core.score.service;

import com.example.manageruniversity.core.score.controller.vo.ScoringEachComponentReqVO;

public interface ScoringEachComponentService {
    /**
     * Nhap diem cho sinh vien
     * @param request: thong tin nhap diem
     */
    void create(ScoringEachComponentReqVO request);

    /**
     * Sua doi diem cho sinh vien
     * sau khi sinh vien co ket qua phuc khao
     * @param scoringEachComponentId: id thanh phan diem co su thanh doi
     * @param request: thong tin can sua
     */
    void update(Long scoringEachComponentId, ScoringEachComponentReqVO request);
}
