package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.TestSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TestScheduleRepository extends JpaRepository<TestSchedule, Long> {

    @Query(value = "select distinct ts.*\n" +
            "from seasons sea\n" +
            "         inner join exams ex on sea.id = ex.season_id\n" +
            "         inner join test_schedules ts on ex.id = ts.exam_id\n" +
            "         inner join test_schedule_student tss on ts.id = tss.test_schedule_id\n" +
            "         inner join students st on tss.student_id = st.id\n" +
            "         inner join registers r on st.id = r.student_id\n" +
            "         inner join major_registers mr on mr.id = r.major_register_id\n" +
            "where sea.id = :seasonId\n" +
            "  and st.id = :studentId", nativeQuery = true)
    List<TestSchedule> findAllBySeasonIdAndStudentId(@Param("seasonId") Long seasonId,
                                                     @Param("studentId") Long studentId);
}
