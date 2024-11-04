package com.example.manageruniversity.core.score.service;

import com.example.manageruniversity.core.score.domain.request.ScoreCoefficientRequest;

public interface ScoreCoefficientService {
    void create(ScoreCoefficientRequest request);
    void update(Long scoreCoefficientId, ScoreCoefficientRequest request);
}
