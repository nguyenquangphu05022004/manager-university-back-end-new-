package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.ExamResponse;
import com.example.manageruniversity.dto.TestScheduleRequest;
import com.example.manageruniversity.dto.TestScheduleResponse;
import com.example.manageruniversity.entity.*;
import com.example.manageruniversity.repository.ExamRepository;
import com.example.manageruniversity.repository.StudentRepository;
import com.example.manageruniversity.repository.TestScheduleRepository;
import com.example.manageruniversity.service.ITestScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestScheduleServiceImpl implements ITestScheduleService {
    private final TestScheduleRepository testScheduleRepository;
    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;
    @Transactional
    @Override
    public void saveOrUpdate(TestScheduleRequest request) {
        Optional<Exam> optionalExam = examRepository.findBySeasonIdAndSubjectIdAndRoomClassId(
                request.getExamRequest().getSeasonId(),
                request.getExamRequest().getSubjectId(),
                request.getExamRequest().getClassRoomId()
        );
        Pageable pageable = PageRequest.of(request.getTestGroup() - 1, request.getNumberOfStudent());
        Page<Student> studentPage = studentRepository
                .findAllBySubjectIdAndSeasonId(
                        request.getExamRequest().getSubjectId(),
                        request.getExamRequest().getSeasonId(),
                        pageable);
        TestSchedule schedule = mapToEntity(request);
        schedule.setStudents(studentPage.getContent());
        if(optionalExam.isPresent()) {
            schedule.setExam(optionalExam.get());
        } else {
            Exam exam = new Exam(
                    new Season(request.getExamRequest().getSeasonId()),
                    new RoomClass(request.getExamRequest().getClassRoomId()),
                    new Subject(request.getExamRequest().getSubjectId()),
                    request.getExamRequest().getTestType()
                    );
            schedule.setExam(exam);
        }
        testScheduleRepository.save(schedule);
    }

    @Override
    public List<TestScheduleResponse> getListBySeasonIdAndStudentId(Long seasonId, Long studentId) {
        List<TestSchedule> testSchedules = testScheduleRepository.findAllBySeasonIdAndStudentId(seasonId, studentId);
        return testSchedules.stream().map(this::mapToDto).toList();
    }

    private TestScheduleResponse mapToDto(TestSchedule schedule) {
        TestScheduleResponse testSchedule = TestScheduleResponse.builder()
                .startDate(schedule.getStartDate())
                .startTime(schedule.getStartTime())
                .endTime(schedule.getEndTime())
                .numberOfStudent(schedule.getNumberOfStudent())
                .testGroup(schedule.getTestGroup())
                .examResponse(ExamResponse.builder()
                        .id(schedule.getExam().getId())
                        .testType(schedule.getExam().getTestType())
                        .subjectName(schedule.getExam().getSubject().getSubjectName())
                        .roomClass(schedule.getExam().getRoomClass().getName())
                        .build())
                .build();
        return testSchedule;
    }

    private TestSchedule mapToEntity(TestScheduleRequest request) {
        TestSchedule studentsTestRoom = TestSchedule.builder()
                .startDate(request.getStartDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .numberOfStudent(request.getNumberOfStudent())
                .testGroup(request.getTestGroup())
                .build();
        return studentsTestRoom;
    }
}
