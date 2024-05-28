package com.example.manageruniversity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private float attend;
    private float midtermTest;
    private float finalTest;
    private float practiceTest;
    private ComponentGradeDTO componentGrade;
    public float getSubjectAverage() {
        if(componentGrade == null) return 0;
        float a =  (attend * componentGrade.getAttend() * 0.01f +
                        midtermTest * componentGrade.getMidtermTest() * 0.01f +
                        finalTest * componentGrade.getFinalTest() * 0.01f +
                        practiceTest * componentGrade.getPracticeTest() * 0.01f);
        return a;
    }
    public EnumGrade getAverageWithFourGrade() {
        float gpa = getSubjectAverage();
        if(gpa >= 9.0) {
            return EnumGrade.A_PLUS;
        } else if(gpa >= 8.5) return EnumGrade.A;
        else if(gpa >= 8.0) return EnumGrade.B_PLUS;
        else if(gpa >= 7.0) return EnumGrade.B;
        else if(gpa >= 6.5) return EnumGrade.C_PLUS;
        else if(gpa >= 5.5) return EnumGrade.C;
        else if(gpa >= 5.0) return EnumGrade.D_PLUS;
        else if(gpa >= 4.0) return EnumGrade.D;
        else return EnumGrade.F;
    }


}
