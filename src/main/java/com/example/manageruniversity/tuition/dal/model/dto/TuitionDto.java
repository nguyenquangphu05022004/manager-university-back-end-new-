package com.example.manageruniversity.tuition.dal.model.dto;

import com.example.manageruniversity.core.schoolYear.domain.dto.SchoolYearDto;
import com.example.manageruniversity.tuition.dal.model.entity.Tuition;
import lombok.Getter;

@Getter
public class TuitionDto {
    private SchoolYearDto schoolYear;
    private Long unAdjustedAmount;
    private Long discountedAmount;
    private Long amountDue;
    private Long amountReceived;
    private Long outstandingBalance;

    public TuitionDto(Tuition tuition) {
        if(tuition != null) {
            this.schoolYear = new SchoolYearDto(tuition.getSchoolYear());
            this.unAdjustedAmount = tuition.getUnAdjustedAmount();
            this.discountedAmount = tuition.getDiscountedAmount();
            this.amountDue = tuition.getAmountDue();
            this.amountReceived = tuition.getAmountDue();
            this.outstandingBalance = tuition.getOutstandingBalance();
        }
    }
}
