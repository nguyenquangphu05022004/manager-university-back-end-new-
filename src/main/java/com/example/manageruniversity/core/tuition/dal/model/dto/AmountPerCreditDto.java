package com.example.manageruniversity.core.tuition.dal.model.dto;

import com.example.manageruniversity.core.course.CourseDto;
import com.example.manageruniversity.core.major.MajorDto;
import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.tuition.dal.model.entity.AmountPerCredit;
import lombok.Getter;

@Getter
public class AmountPerCreditDto {
    private Integer amount;
    private SchoolYearDto schoolYear;
    private CourseDto course;
    private MajorDto major;

    public AmountPerCreditDto(AmountPerCredit amountPerCredit) {
        if (amountPerCredit != null) {
            this.amount = amountPerCredit.getAmount();
            this.schoolYear = new SchoolYearDto(amountPerCredit.getSchoolYear());
            this.course = new CourseDto(amountPerCredit.getCourse());
            this.major = new MajorDto(amountPerCredit.getMajor());
        }
    }
}
