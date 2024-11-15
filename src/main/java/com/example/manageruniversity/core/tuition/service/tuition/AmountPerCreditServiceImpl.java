package com.example.manageruniversity.core.tuition.service.tuition;

import com.example.manageruniversity.core.tuition.controller.vo.AmountPerCreditReqVO;
import com.example.manageruniversity.core.tuition.dal.dataobject.AmountPerCredit;
import com.example.manageruniversity.core.tuition.dal.repo.AmountPerCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AmountPerCreditServiceImpl implements AmountPerCreditService{
    private final AmountPerCreditRepository amountPerCreditRepository;

    @Override
    public void create(AmountPerCreditReqVO request) {
        AmountPerCredit amountPerCredit = new AmountPerCredit(
            request.getAmount(),
            request.getSchoolYearId(),
            request.getMajorId(),
            request.getCourseId()
        );
        this.amountPerCreditRepository.save(amountPerCredit);
    }

    @Override
    public void update(Long id, AmountPerCreditReqVO reqVO) {
        AmountPerCredit amountPerCredit = new AmountPerCredit(
                reqVO.getAmount(),
                reqVO.getSchoolYearId(),
                reqVO.getMajorId(),
                reqVO.getCourseId()
        );

        amountPerCredit.setId(id);
        this.amountPerCreditRepository.save(amountPerCredit);

    }

    @Override
    public void delete(Long id) {
        this.amountPerCreditRepository.deleteById(id);
    }

    @Override
    public List<AmountPerCredit> getList() {
        return amountPerCreditRepository.findAll();
    }
}
