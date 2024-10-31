package com.example.manageruniversity.core.major.service;

import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.core.major.domain.request.MajorRequest;

import java.util.List;

public interface MajorService {
    Major update(MajorRequest majorDto);
    List<Major> getAll();
    Major getById(String majorId);

}
