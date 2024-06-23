package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.AspirationRegisterDTO;
import com.example.manageruniversity.dto.AspirationRegisterRequest;
import com.example.manageruniversity.entity.AspirationRegister;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.AspirationRegisterMapper;
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
        return AspirationRegisterMapper
                .mapper
                .mapToDto(aspirationRegisterRepository.save(as));
    }

    @Override
    public List<AspirationRegisterDTO> records() {
        List<AspirationRegisterDTO> resultList = aspirationRegisterRepository.findAll()
                .stream()
                .map(aspi -> AspirationRegisterMapper
                        .mapper
                        .mapToDto(aspi))
                .collect(Collectors.toList());
        return resultList;
    }

    @Override
    public void delete(Long id) {
        aspirationRegisterRepository.deleteById(id);
    }
}
