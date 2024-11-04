package com.example.manageruniversity.core.major;

import org.springframework.data.domain.Page;

import java.util.List;

public interface MajorService {
    Major update(MajorRequest majorDto);
    Page<Major> getAll(int page);
    Major getById(String majorId);

}
