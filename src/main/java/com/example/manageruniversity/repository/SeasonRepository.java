package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.utils.SystemUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.backoff.BackOff;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    List<Season> findAllByDisabled(boolean disabled);
    @Query("select s from Season s " +
            "inner join Courses c on s.courses.id = c.id " +
            "where c.id = :coursesId " +
            "order by s.id desc ")
    List<Season> findAllByCoursesIdAndOrderByIdDesc(@PathVariable("coursesId") Long coursesId);

    @Query("select s from Season s inner join AspirationOfStudent  aspi " +
            "on s.id = aspi.season.id inner join Student st on aspi.student.id = st.id " +
            "where st.id = :studentId and aspi.approval = true " +
            "order by s.id desc ")
    List<Season> findSeasonExtraByStudentId(Long studentId);

//    @Query(value = "select sea.* from seasons sea inner join courses c\n" +
//            "on sea.courses_id = c.id\n" +
//            "where c.code = '" + SystemUtils.ANONYMOUS + "'", nativeQuery = true)
    @Query("SELECT s from Season s inner join Courses c on s.courses.id = c.id " +
            "where c.code = :code")
    List<Season> findSeasonExtraByAnonymous(@Param("code") String code);
}
