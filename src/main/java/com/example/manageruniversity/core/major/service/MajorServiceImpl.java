package com.example.manageruniversity.core.major.service;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.common.string.StringUtils;
import com.example.manageruniversity.core.major.domain.dto.MajorDto;
import com.example.manageruniversity.core.major.domain.entity.Major;
import com.example.manageruniversity.core.major.domain.request.MajorRequest;
import com.example.manageruniversity.core.major.repo.MajorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MajorServiceImpl implements MajorService{
    private final MajorRepository majorRepository;
    @Override
    public Major update(MajorRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request, "parentId");
        Major major = null;
        try {
            major = this.getById(request.getMajorId());
        } catch (ResourcesNotFoundException e) {
            log.info("Update major");
        }
        if(ObjectUtils.isNull(major)) {
            major = new Major(request.getMajorId(), request.getName());
        } else {
            major.setName(request.getName());
        }
        if(StringUtils.isEmpty(request.getMajorParentId())) {
            Major majorParent = this.getById(request.getMajorId());
            major.setParentMajorId(majorParent);
        }
        this.majorRepository.save(major);
        return major;
    }

    @Override
    public List<Major> getAll() {
        return this.majorRepository.findAll();
    }

    @Override
    public Major getById(String majorId) {
        return this.majorRepository.findById(majorId)
                .orElseThrow(() -> new ResourceAccessException("Major not found"));
    }
}
