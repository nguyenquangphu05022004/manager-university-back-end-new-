package com.example.manageruniversity.core.score.service;

import com.example.manageruniversity.core.score.domain.request.ScoringEachComponentRequest;

public interface ScoringEachComponentService {
    void create(ScoringEachComponentRequest request);
    void update(Long scoringEachComponentId, ScoringEachComponentRequest request);
}
