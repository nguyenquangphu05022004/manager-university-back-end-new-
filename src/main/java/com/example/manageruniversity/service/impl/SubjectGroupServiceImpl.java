package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.SubjectGroupMapper;
import com.example.manageruniversity.repository.SubjectGroupRepository;
import com.example.manageruniversity.repository.TeacherRepository;
import com.example.manageruniversity.service.ISubjectGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectGroupServiceImpl implements ISubjectGroupService {
    private final SubjectGroupRepository subjectGroupRepository;
    private final TeacherRepository teacherRepository;


    @Override
    public SubjectGroupDTO saveOrUpdate(SubjectGroupDTO subjectGroupDTO) {
        SubjectGroup subjectGroup  = null;
        if(subjectGroupDTO.getId() != null) {

        } else {
            subjectGroup = SubjectGroupMapper.mapper.subjectGroupDTOToEntity(subjectGroupDTO);
        }
        subjectGroup = subjectGroupRepository.save(subjectGroup);
        return SubjectGroupMapper.mapper.subjectGroupToDTO(subjectGroup);
    }

    @Override
    public List<SubjectGroupDTO> records() {
        List<SubjectGroup> subjectGroups = subjectGroupRepository.findAll();
        return subjectGroups.stream().map(subjectGroup -> {
            return SubjectGroupMapper.mapper.subjectGroupToDTO(subjectGroup);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        subjectGroupRepository.deleteById(id);
    }

    @Override
    public List<SubjectGroupDTO> findAllBySubjectId(Long subjectId) {
        List<SubjectGroup> subjectGroups = subjectGroupRepository.findAllBySubjectId(subjectId);
        List<SubjectGroupDTO> subjectGroupDTOList = subjectGroups.stream().map(subjectGroup -> {
            return SubjectGroupMapper.mapper.subjectGroupToDTO(subjectGroup);
        }).collect(Collectors.toList());
        return subjectGroupDTOList;
    }

    @Override
    public void updateTeacher(Long subjectGroupId, String teacherCode) {
        SubjectGroup subjectGroup = subjectGroupRepository.findById(subjectGroupId).get();
        Optional<Teacher> byUserUsername =
                teacherRepository.findByUserUsername(teacherCode);
        if(byUserUsername.isPresent()) {
            subjectGroup.setTeacher(byUserUsername.get());
            subjectGroupRepository.save(subjectGroup);
            return;
        }
        throw new NotFoundIdException("Teacher", "Username(Code)", teacherCode);

    }
}
