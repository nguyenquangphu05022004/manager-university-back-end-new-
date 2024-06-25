package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.AspirationRegisterDTO;
import com.example.manageruniversity.dto.AspirationRegisterRequest;
import com.example.manageruniversity.entity.AspirationRegister;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.AspirationRegisterMapper;
import com.example.manageruniversity.mapper.SubjectMapper;
import com.example.manageruniversity.repository.AspirationRegisterRepository;
import com.example.manageruniversity.repository.SeasonRepository;
import com.example.manageruniversity.service.IAspirationRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AspirationRegisterServiceImpl implements IAspirationRegisterService {

    private final AspirationRegisterRepository aspirationRegisterRepository;
    private final SeasonRepository seasonRepository;

    @Override
    @Transactional
    public AspirationRegisterDTO saveOrUpdate(AspirationRegisterRequest request) {
        Season season = seasonRepository.findById(request.getSeasonId())
                .orElseThrow(() -> new NotFoundIdException(
                        "Season",
                        "SeasonId",
                        request.getSeasonId())
                );
        AspirationRegister as = AspirationRegister
                .builder()
                .season(season)
                .end(request.getEnd())
                .start(request.getStart())
                .build();
        return getMapToDto(aspirationRegisterRepository.save(as));
    }

    @Override
    public List<AspirationRegisterDTO> records() {
        List<AspirationRegisterDTO> resultList = aspirationRegisterRepository.findAllByOrderById()
                .stream()
                .map(aspi -> getMapToDto(aspi)
                )
                .collect(Collectors.toList());
        return resultList;
    }

    private static AspirationRegisterDTO getMapToDto(AspirationRegister aspi) {

        AspirationRegisterDTO aspirationRegisterDTO = AspirationRegisterMapper
                .mapper
                .mapToDto(aspi);
        if (aspi.getListSubject() != null) {
            List<AspirationRegisterDTO.SubjectApproval> subjectApprovals = aspi.getListSubject()
                    .entrySet()
                    .stream()
                    .map(entry -> new AspirationRegisterDTO
                            .SubjectApproval(
                            SubjectMapper.mapper.subjectToDTO(entry.getKey()),
                            entry.getValue()
                    ))
                    .toList();
            aspirationRegisterDTO.setSubjectApprovals(subjectApprovals);
        }
        return aspirationRegisterDTO;
    }

    @Override
    public void delete(Long id) {
        aspirationRegisterRepository.deleteById(id);
    }
}
