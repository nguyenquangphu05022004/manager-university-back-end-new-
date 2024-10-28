package com.example.manageruniversity.score.service;

import com.example.manageruniversity.score.domain.request.ScoreCoefficientRequest;

public interface ScoreCoefficientService {
    void create(ScoreCoefficientRequest request);
    void update(Long scoreCoefficientId, ScoreCoefficientRequest request);
}
