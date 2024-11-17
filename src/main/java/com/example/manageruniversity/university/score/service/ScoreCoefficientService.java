package com.example.manageruniversity.university.score.service;

import com.example.manageruniversity.university.score.controller.vo.ScoreCoefficientReqVO;
import com.example.manageruniversity.university.score.dal.entity.ScoreCoefficient;

import java.util.List;

public interface ScoreCoefficientService {
    /**
     * Tao trong so diem cho mon hoc theo tun hoc ky
     * @param request: thong tin  de tao
     */
    void create(ScoreCoefficientReqVO request);

    /**
     * Sua trong so diem
     * @param scoreCoefficientId: ma
     * @param request: thong tin
     */
    void update(Long scoreCoefficientId, ScoreCoefficientReqVO request);

    /**
     * Lay toan bo thong tin chi tiet ve dau diem
     * cua tung mon hoc theo hoc ky
     * @return
     */
    List<ScoreCoefficient> getList();


    /**
     * Lay toan bo trong so diem thanh phan
     * cua mon hoc theo tung hoc ky
     * @param schoolYearId: ma hoc ky/nam hoc
     * @param subjectId: ma mon hoc
     * @return: Danh sach trong so diem thanh phan
     */
    List<ScoreCoefficient> getListBySchoolYearIdAndSubjectId(
            Long schoolYearId,
            String subjectId
    );

}
