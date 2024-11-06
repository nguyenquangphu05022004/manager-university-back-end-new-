package com.example.manageruniversity.core.major;

import com.example.manageruniversity.common.pojo.PageResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MajorService {
    Major update(MajorRequest majorDto);
    List<Major> getAll();
    Major getById(String majorId);

}
