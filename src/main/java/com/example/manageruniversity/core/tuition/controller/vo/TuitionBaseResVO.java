package com.example.manageruniversity.core.tuition.controller.vo;

import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.tuition.dal.entity.Tuition;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TuitionBaseResVO {
    private SchoolYearDto schoolYear;
    private Long unAdjustedAmount;
    private Long discountedAmount;
    private Long amountDue;
    private Long amountReceived;
    private Long outstandingBalance;

    public TuitionBaseResVO(Tuition tuition) {
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
