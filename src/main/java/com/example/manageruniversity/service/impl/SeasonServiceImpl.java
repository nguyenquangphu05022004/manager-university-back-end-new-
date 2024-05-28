package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.*;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.mapper.MajorMapper;
import com.example.manageruniversity.mapper.MajorRegisterMapper;
import com.example.manageruniversity.mapper.SeasonMapper;
import com.example.manageruniversity.mapper.SubjectMapper;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.repository.SeasonRepository;
import com.example.manageruniversity.service.ISeasonService;
import com.example.manageruniversity.utils.SystemUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements ISeasonService {
    private final SeasonRepository seasonRepository;


    @Override
    public SeasonDTO saveOrUpdate(SeasonDTO seasonDTO) {
        Optional<Season> byCondition = seasonRepository.findByCoursesIdAndSchoolYearIdAndSemesterId(
                seasonDTO.getCourses().getId(),
                seasonDTO.getSchoolYear().getId(),
                seasonDTO.getSemester().getId()
        );
        if(byCondition.isPresent()) {
            throw new RuntimeException(String
                    .format("Đã tồn tại Season với courses: %s schoolYear: %s and Semester: %s",
                    seasonDTO.getCourses().getId(),
                    seasonDTO.getSchoolYear().getId(),
                    seasonDTO.getSemester().getId()
                    ));
        }
        Season season = SeasonMapper.mapper.seasonDTOToEntity(seasonDTO);
        seasonRepository.save(season);
        return null;
    }

    @Override
    public List<SeasonDTO> records() {
        List<Season> seasons = seasonRepository.findAll();
        return seasons.stream().map(season -> {
            SeasonDTO seasonDTO = SeasonMapper.mapper.seasonToDTO(season);
            List<MajorRegisterDTO> majorRegisterDTOS = new ArrayList<>();
            for(var mr : season.getMajorRegisters()) {
                MajorRegisterDTO majorRegisterDTO = MajorRegisterMapper.mapper.majorRegisterToDTO(mr);
                majorRegisterDTOS.add(majorRegisterDTO);
            }
            seasonDTO.setMajorRegisterDTOS(majorRegisterDTOS);
            return seasonDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        seasonRepository.deleteById(id);
    }


    @Override
    public SeasonDTO findById(Long seasonId) {
        Season season = seasonRepository.findById(seasonId).orElseThrow();
        return SeasonMapper.mapper.seasonToDTO(season);

    }

    @Override
    public List<SeasonDTO> getListSeasonByCoursesId(Long coursesId) {
        var list = seasonRepository.findAllByCoursesIdAndOrderByIdDesc(coursesId);
        return list.stream()
                .map(e -> SeasonMapper.mapper.seasonToDTO(e))
                .toList();
    }

    @Override
    public List<SeasonDTO> getListSeasonByDisabled(boolean disabled) {
       var list = seasonRepository.findAllByDisabled(disabled);
        return list.stream()
                .map(e -> SeasonMapper.mapper.seasonToDTO(e))
                .toList();
    }

    @Override
    public List<SeasonDTO> getListSeasonExtraByStudentId(Long studentId) {
        List<Season> listExtraSeasonOfStudent = seasonRepository.findSeasonExtraByStudentId(studentId);
        return listExtraSeasonOfStudent.stream()
                .map(e -> SeasonMapper.mapper.seasonToDTO(e))
                .toList();
    }

    @Override
    public List<SeasonDTO> getListSeasonExtra() {
        List<Season> list = seasonRepository.findSeasonExtraByAnonymous(SystemUtils.ANONYMOUS);
        return list.stream()
                .map(e -> SeasonMapper.mapper.seasonToDTO(e))
                .toList();
    }
}
