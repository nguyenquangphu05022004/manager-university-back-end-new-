package com.example.manageruniversity.university.credit_class.registration.service;


import com.example.manageruniversity.common.exception.ResourcesNotFoundException;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.university.credit_class.registration.domain.dto.request.CreditClassExchangeReqVO;
import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassExchange;
import com.example.manageruniversity.university.credit_class.registration.domain.entities.CreditClassRegistration;
import com.example.manageruniversity.university.credit_class.registration.repo.CreditClassExchangeRepository;
import com.example.manageruniversity.university.credit_class.registration.repo.CreditClassRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditClassExchangeServiceImpl implements CreditClassExchangeService {

    private final CreditClassExchangeRepository creditClassExchangeRepository;
    private final CreditClassRegistrationRepository creditClassRegistrationRepository;
    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public CreditClassExchange sendRequest(CreditClassExchangeReqVO request) {
        ObjectUtils.throwIfContainsAttributeIsNullOrEmpty(request);
        CreditClassExchange object = new CreditClassExchange(
                request.getFromStudentId(),
                request.getCreditClassIdRequest(),
                request.getCreditClassIdTarget(),
                request.getToStudentId()
        );
        this.creditClassExchangeRepository.save(object);
        return object;
    }


    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void processAccept(Long enId) {
        CreditClassExchange creditClassExchange = this.creditClassExchangeRepository.findById(enId)
                .orElseThrow(() -> new ResourcesNotFoundException("not found"));

        CreditClassRegistration request = creditClassRegistrationRepository.findByStudentIdAndCreditClassId(
                creditClassExchange.getFromStudent().getId(),
                creditClassExchange.getRequest().getId()
        ).orElseThrow(() -> new ResourcesNotFoundException("not found"));

        CreditClassRegistration target = creditClassRegistrationRepository.findByStudentIdAndCreditClassId(
                creditClassExchange.getToStudent().getId(),
                creditClassExchange.getTarget().getId()
        ).orElseThrow(() -> new ResourcesNotFoundException("not found"));


        request.setStudent(creditClassExchange.getToStudent());
        target.setStudent(creditClassExchange.getFromStudent());

        this.creditClassRegistrationRepository.save(target);
        this.creditClassRegistrationRepository.save(request);
        this.processDelete(enId);

    }

    @Override
    public void processDelete(Long enId) {
        this.creditClassExchangeRepository.deleteById(enId);
    }

    @Override
    public List<CreditClassExchange> getListByStudentIdAndCreditClassId(Long studentId, Long creditClassId) {
        return this.creditClassExchangeRepository.findAllByToStudentIdAndTargetId(
                studentId,
                creditClassId
        );
    }
}
