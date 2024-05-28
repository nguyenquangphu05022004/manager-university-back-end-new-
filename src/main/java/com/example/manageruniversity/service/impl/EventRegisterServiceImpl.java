package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.EventRegisterRequest;
import com.example.manageruniversity.dto.EventRegisterResponse;
import com.example.manageruniversity.entity.EventRegister;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.repository.EventRegisterRepository;
import com.example.manageruniversity.repository.MajorRegisterRepository;
import com.example.manageruniversity.service.IEventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventRegisterServiceImpl implements IEventRegisterService {

    private final EventRegisterRepository eventRegisterRepository;
    private final MajorRegisterRepository majorRegisterRepository;
    @Override
    public EventRegisterResponse saveOrUpdate(
            EventRegisterRequest eventRegisterRequest
    ) {
        EventRegister eventRegister = EventRegister.builder()
                .end(eventRegisterRequest.getEnd())
                .start(eventRegisterRequest.getStart())
                .build();
        EventRegister saved = eventRegisterRepository.save(eventRegister);
        eventRegisterRequest.getMajorIds().forEach(majorId -> {
            MajorRegister majorRegister = majorRegisterRepository.findBySeasonIdAndMajorId(eventRegisterRequest.getSeasonId(),majorId);
            if(majorRegister != null) {
                majorRegister.setEventRegister(saved);
                majorRegisterRepository.save(majorRegister);
            }
        });
        return toResponse(eventRegister);

    }

    private EventRegisterResponse toResponse(EventRegister eventRegister) {
        List<String> fullNameMajorRegisters = new ArrayList<>();
        if(eventRegister.getMajorRegisters() != null) {
            for(MajorRegister majorRegister : eventRegister.getMajorRegisters()) {
                String fullNameSeason = majorRegister.getSeason().getFullNameSeason();
                String majorName = majorRegister.getMajor().getName();
                fullNameMajorRegisters.add(fullNameSeason + " ngành " + majorName);
            }
        }
        return EventRegisterResponse.builder()
                .id(eventRegister.getId())
                .end(eventRegister.getEnd())
                .start(eventRegister.getStart())
                .nameMajorRegister(fullNameMajorRegisters)
                .build();
    }

    @Override
    public List<EventRegisterResponse> records() {
        return eventRegisterRepository.findAll().stream().map(e -> toResponse(e)).toList();
    }

    @Override
    public void delete(Long id) {

    }
}
