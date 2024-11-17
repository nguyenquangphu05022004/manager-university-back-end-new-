package com.example.manageruniversity.university.score.service;

import com.example.manageruniversity.common.collection.CollUtils;
import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassRegistration;
import com.example.manageruniversity.university.credit_class.registration.repo.CreditClassRegistrationRepository;
import com.example.manageruniversity.university.score.dal.entity.Score;
import com.example.manageruniversity.university.score.dal.repo.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.manageruniversity.common.collection.ListUtils.convertToList;
import static com.example.manageruniversity.common.collection.MapUtils.convertToMap;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService{

    /**
     * Repo cho phep truy cap ban ghi dang ky lop hoc tin chi cua sinh vien
     */
    private final CreditClassRegistrationRepository creditClassRegistrationRepository;
    private final ScoreRepository scoreRepository;
    @Override
    @Transactional
    public void initForAllStudentBySchoolYearId(Long schoolYearId) {

        List<Score> scores = this.scoreRepository.findAllBySchoolYearId(schoolYearId);
        if(CollUtils.isEmpty(scores)) return;
        List<CreditClassRegistration> creditClassRegistrations = this.creditClassRegistrationRepository.findAllBySchoolYearId(schoolYearId);
        creditClassRegistrations.forEach(record -> {
            Score score = new Score(
                    record.getStudent(),
                    record.getCreditClass().getSubject(),
                    record.getSchoolYear()
            );
            this.scoreRepository.save(score);
        });
    }

    @Override
    public List<Score> getAllByStudentId(Long studentId) {
        return this.scoreRepository.findAllByStudentId(studentId);
    }
}
