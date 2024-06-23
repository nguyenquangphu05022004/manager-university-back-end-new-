package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.MajorRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MajorRegisterRepository extends JpaRepository<MajorRegister, Long> {
    MajorRegister findBySeasonIdAndMajorId(Long seasonId, Long majorId);
    MajorRegister findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled);
    @Query("select mr from Courses c inner join Season se on c.id = se.courses.id " +
            " inner join MajorRegister mr on se.id = mr.season.id inner join Major m on mr.major.id = m.id " +
            "inner join Student st on m.id = st.major.id " +
            "where st.id = :studentId and c.id = :coursesId")
    List<MajorRegister> findAllByStudentIdAndCoursesId(@Param("studentId") Long studentId,
                                           @Param("coursesId") Long coursesId);


//    @Query("select mr from Courses c inner join Season s on c.id = s.courses.id " +
//            "inner join MajorRegister mr on s.id = mr.season.id inner join Major m on mr.major.id = m.id " +
//            "inner join Student st on m.id = st.major.id " +
//            "where st.id = :studentId and s.disabled = false and c.id = :coursesIdOfStudent")
//    Optional<MajorRegister> findByStudentIdAndSeasonNotDisabledAndOpenRegisterAndCoursesOfStudent(Long studentId,
//                                                                                                  Long coursesIdOfStudent);
    @Query("select mr from Season sea inner join MajorRegister mr on sea.id = mr.season.id" +
            " inner join Major major on mr.major.id = major.id " +
            "inner join Student s on s.major.id = major.id " +
            "where s.id = :studentId and sea.id = :seasonId")
    Optional<MajorRegister> findByStudentIdAndSeasonId(@Param("studentId") Long studentId,
                                                       @Param("seasonId") Long seasonId);
    @Query("select mr from Student s inner join AspirationOfStudent asp on s.id = asp.student.id " +
            "inner join AspirationRegister aspiRegister on asp.aspirationRegister.id = aspiRegister.id " +
            "inner join Season sea on aspiRegister.season.id = sea.id " +
            "inner join MajorRegister mr on sea.id = mr.season.id " +
            "where s.id = :studentId and sea.id = :seasonId")
    Optional<MajorRegister> findByStudentIdAndSeasonIdExtra(@Param("studentId") Long studentId,
                                                            @Param("seasonId") Long seasonId);

    @Query("select mr from MajorRegister  mr inner join " +
            "Season sea on mr.season.id = sea.id inner join AspirationRegister  aspiRegister on sea.id = aspiRegister.season.id " +
            "inner join AspirationOfStudent  aspi on aspi.aspirationRegister.id = aspiRegister.id " +
            "inner join Student st on st.id = aspi.student.id " +
            "where st.id = :studentId")
    List<MajorRegister> findAllExtraByStudentId(Long studentId);
}
