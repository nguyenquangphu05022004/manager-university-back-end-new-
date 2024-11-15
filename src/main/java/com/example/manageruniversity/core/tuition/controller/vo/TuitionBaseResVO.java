package com.example.manageruniversity.core.tuition.controller.vo;

import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.tuition.dal.dataobject.Tuition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(name = "Tuition - Thong tin ve hoc phi")
public class TuitionBaseResVO {
    @Schema(description = "Ky hoc")
    private SchoolYearDto schoolYear;
    @Schema(description = "So tien chua dieu chinh")
    private Long unAdjustedAmount;
    @Schema(description = "So tien sau khi giam")
    private Long discountedAmount;
    @Schema(description = "so tien phai dong")
    private Long amountDue;
    @Schema(description = "so tien da dong")
    private Long amountReceived;
    @Schema(description = "so tien con no")
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
