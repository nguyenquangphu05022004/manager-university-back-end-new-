package com.example.manageruniversity.core.school_year;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.pojo.PageConstant;
import com.example.manageruniversity.common.pojo.PageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolYearServiceImpl implements SchoolYearService {
    private final SchoolYearRepository schoolYearRepository;
    @Override
    public SchoolYear update(SchoolYearRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request, "id");
        SchoolYear schoolYear = null;
        try {
            schoolYear = this.getById(request.getId());
        } catch (Exception e) {
            log.info("update school year");
        }
        if(ObjectUtils.isNull(schoolYear)) {
            schoolYear = new SchoolYear(request.getFrom(), request.getTo(), Semester.findByIndex(request.getSemester()));
        } else {
            schoolYear.setToYear(request.getTo());
            schoolYear.setFromYear(request.getFrom());
            schoolYear.setSemester(Semester.findByIndex(request.getSemester()));
        }
        this.schoolYearRepository.save(schoolYear);
        return schoolYear;
    }

    @Override
    public Page<SchoolYear> getAllByCourseId(String courseId, int page) {
        return  this.schoolYearRepository.findAllByCourseId(
                courseId,
                PageRequest.of(page - 1, PageConstant.LIMIT)
        );
    }

    @Override
    public SchoolYear getById(Long schoolYearId) {
        return this.schoolYearRepository.findById(schoolYearId)
                .orElseThrow(() -> new ResourcesNotFoundException("SchoolYear not found"));
    }
}
