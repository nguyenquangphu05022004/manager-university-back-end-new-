package com.example.manageruniversity.university.credit_class.time_table;

import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.university.credit_class.self.CreditClassService;
import com.example.manageruniversity.university.credit_class.time_table.vo.TimeTableCreateReqVO;
import com.example.manageruniversity.university.location.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimeTableServiceImpl implements TimeTableService{
    private final RoomService roomService;
    private final TimeTableRepository timeTableRepository;
    private final CreditClassService creditClassService;
    @Override
    public TimeTable create(TimeTableCreateReqVO request) {
        TimeTable timeTable  = new TimeTable(
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

    @Override
    public List<TimeTable> getAllByCreditClassId(Long creditClassId) {
        return this.timeTableRepository.findAllByCreditClassId(creditClassId);
    }
}
