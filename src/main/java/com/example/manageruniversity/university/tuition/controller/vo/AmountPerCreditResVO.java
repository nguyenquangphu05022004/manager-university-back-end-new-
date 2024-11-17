package com.example.manageruniversity.university.tuition.controller.vo;

import com.example.manageruniversity.university.course.CourseDto;
import com.example.manageruniversity.university.major.MajorDto;
import com.example.manageruniversity.university.school_year.SchoolYearDto;
import com.example.manageruniversity.university.tuition.dal.dataobject.AmountPerCredit;
import lombok.Data;

@Data
public class AmountPerCreditResVO {
    private Integer amount;
    private SchoolYearDto schoolYear;
    private CourseDto course;
    private MajorDto major;

    public AmountPerCreditResVO(AmountPerCredit amountPerCredit) {
        if (amountPerCredit != null) {
            this.amount = amountPerCredit.getAmount();
            this.schoolYear = new SchoolYearDto(amountPerCredit.getSchoolYear());
            this.course = new CourseDto(amountPerCredit.getCourse());
            this.major = new MajorDto(amountPerCredit.getMajor());
        }
    }
}
