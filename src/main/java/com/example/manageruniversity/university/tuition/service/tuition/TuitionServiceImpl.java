package com.example.manageruniversity.university.tuition.service.tuition;

import com.example.manageruniversity.common.collection.CollUtils;
import com.example.manageruniversity.university.credit_class.registration.repo.CreditClassRegistrationRepository;
import com.example.manageruniversity.university.instruction.MajorSubjectSelectionRepository;
import com.example.manageruniversity.university.major.Major;
import com.example.manageruniversity.university.member.dal.entities.Student;
import com.example.manageruniversity.university.member.dal.repo.StudentRepository;
import com.example.manageruniversity.university.subject.Subject;
import com.example.manageruniversity.university.tuition.dal.dataobject.AmountPerCredit;
import com.example.manageruniversity.university.tuition.dal.dataobject.Tuition;
import com.example.manageruniversity.university.tuition.dal.repo.AmountPerCreditRepository;
import com.example.manageruniversity.university.tuition.dal.repo.TuitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TuitionServiceImpl implements TuitionService{

    private final TuitionRepository tuitionRepository;
    private final AmountPerCreditRepository amountPerCreditRepository;
    private final CreditClassRegistrationRepository creditClassRegistrationRepository;
    private final MajorSubjectSelectionRepository majorSubjectSelectionRepository;
    private final StudentRepository studentRepository;
    @Override
    public List<Tuition> getAllByStudentId(Long studentId) {
        return tuitionRepository.findByStudentId(studentId);
    }

    @Override
    @Transactional
    public void createForAllStudentBySchoolYearIdAndCourseId(Long schoolYearId, String courseId) {

        /**
         * Lay majors
         */
        Set<Major> majors = CollUtils.convertToSet(
                majorSubjectSelectionRepository.findAllBySchoolYearIdAndCourseCourseId(schoolYearId, courseId),
                s -> s.getMajor()
        );

        majors.stream()
                .forEach(major -> {
                    /**
                     * lay sinh vien
                     */
                    List<Student> students = this.studentRepository.findAllByMajorMajorIdAndCourseCourseId(major.getMajorId(), courseId);
                    students.stream().forEach(student -> {
                        /**
                         * Get all subjects which were registered
                         */
                        Set<Subject> subjects = CollUtils.convertToSet(
                                this.creditClassRegistrationRepository.findAllByStudentIdAndSchoolYearId(student.getId(), schoolYearId),
                                s -> s.getCreditClass().getSubject()
                        );


                        AmountPerCredit amountPerCredit = this.amountPerCreditRepository
                                .findBySchoolYearIdAndMajorMajorIdAndCourseCourseId(schoolYearId, major.getMajorId(), courseId);
                        Long unAdjustedAmount = subjects.stream().mapToLong(s -> s.getCredit() * amountPerCredit.getAmount()).sum();

                        /**
                         * Discount Amount: When have changed at amount per credit we
                         * will change tuition of student.
                         * Example: Assume current amount for a credit is 650.000, but
                         * in some day its reduce to 600.000
                         * Then discount amount = total(before reduce amount of credit) - total(after reduce amount of credit)
                         */

                        /**
                         * In other case: If student received scholarship from
                         * college, so amount of discount is (before + scholarship)
                         */

                        /**
                         * Amount received: that amount is paid by student,
                         *
                         */

                        Tuition tuition = new Tuition(
                                schoolYearId,
                                student.getId(),
                                unAdjustedAmount, //amount before reduce
                                0l, // amount after reduce
                                unAdjustedAmount, //amount due
                                0l, // amount that student must be paid
                                unAdjustedAmount //balance that student is not  pay full
                        );

                        this.tuitionRepository.save(tuition);

                    });
                });

    }
}
