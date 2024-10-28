package com.example.manageruniversity.score.service;

import com.example.manageruniversity.score.domain.request.ScoringEachComponentRequest;

public interface ScoringEachComponentService {
    void create(ScoringEachComponentRequest request);
    void update(Long scoringEachComponentId, ScoringEachComponentRequest request);
}
