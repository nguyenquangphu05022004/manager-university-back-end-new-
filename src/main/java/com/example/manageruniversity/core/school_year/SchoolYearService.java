package com.example.manageruniversity.core.school_year;

import com.example.manageruniversity.common.pojo.PageResult;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface SchoolYearService {
    SchoolYear update(SchoolYearRequest request);
    List<SchoolYear> getAllByCourseId(String courseId);
    SchoolYear getById(Long schoolYearId);

    List<SchoolYear> getAll();
}
