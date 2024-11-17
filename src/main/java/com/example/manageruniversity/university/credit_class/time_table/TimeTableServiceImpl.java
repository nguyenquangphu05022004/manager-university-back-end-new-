package com.example.manageruniversity.university.credit_class.time_table;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.university.credit_class.self.CreditClassService;
import com.example.manageruniversity.university.location.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimeTableServiceImpl implements TimeTableService{
    private final RoomService roomService;
    private final TimeTableRepository timeTableRepository;
    private final CreditClassService creditClassService;
    @Override
    public TimeTable createOrUpdate(TimeTableRequest request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request, "id");
        TimeTable timeTable = null;
        try {
            timeTable = getById(request.getId());
        } catch (ResourcesNotFoundException exception) {
            log.info("update timetable");
        }

        timeTable = new TimeTable(
                ObjectUtils.isNull(timeTable) ? null : timeTable.getId(),
                request.getStartDate(), request.getEndDate(),
                request.getStartTime(), request.getEndTime(),
                request.getDayOfWeek(), request.getTimeType(),
                creditClassService.getById(request.getCreditClassId()),
                roomService.getById(request.getRoomId())
        );

        return timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable getById(Long id) {
        return timeTableRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("timetable not found"));
    }

    @Override
    public void delete(Long timeTableId) {
        this.timeTableRepository.deleteById(timeTableId);
    }

    @Override
    public void deleteByCreditClass(Long creditClassId) {
        this.timeTableRepository.deleteAllByCreditClassId(creditClassId);
    }
}
