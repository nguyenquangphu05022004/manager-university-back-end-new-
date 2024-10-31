package com.example.manageruniversity.tuition.dal.model.dto;

import com.example.manageruniversity.core.course.domain.dto.Course;
import com.example.manageruniversity.core.major.domain.dto.MajorDto;
import com.example.manageruniversity.core.schoolYear.domain.dto.SchoolYearDto;
import com.example.manageruniversity.tuition.dal.model.entity.AmountPerCredit;
import lombok.Getter;

@Getter
public class AmountPerCreditDto {
    private Integer amount;
    private SchoolYearDto schoolYear;
    private Course course;
    private MajorDto major;

    public AmountPerCreditDto(AmountPerCredit amountPerCredit) {
        if (amountPerCredit != null) {
            this.amount = amountPerCredit.getAmount();
            this.schoolYear = new SchoolYearDto(amountPerCredit.getSchoolYear());
            this.course = new Course(amountPerCredit.getCourse());
            this.major = new MajorDto(amountPerCredit.getMajor());
        }
    }
}
