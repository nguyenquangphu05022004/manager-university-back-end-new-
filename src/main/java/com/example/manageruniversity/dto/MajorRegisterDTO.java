package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
public class MajorRegisterDTO extends BaseDTO {
    private List<SubjectDTO> subjectDTOS = new ArrayList<>();
    private MajorDTO majorDTO;
    private SeasonDTO seasonDTO;
    private TuitionDTO tuitionDTO;
    //(this register of only student when login to system)
    //i must filter list register by username and season not end of course current
    private List<RegisterDTO> registerDTOS = new ArrayList<>();
    private boolean openRegister;
    private PaymentResponse paymentOfPerStudentAtCurrentSeason;
    private EventRegisterResponse eventRegisterResponse;
    public Integer getTotalCreditOfStudent() {
        var t = 0;
        for(var s : registerDTOS) {
            t += s.getSubjectGroup().getSubject().getCredit();
        }
        return t;
    }
    public Integer getTotalCreditOfMajor() {
        var t = 0;
        for(var s : subjectDTOS) {
            t += s.getCredit();
        }
        return t;
    }
    public Integer getTotalPrice() {
        int t = 0;
        for(var r : registerDTOS) {
            if(tuitionDTO != null) {
                t += tuitionDTO.getMoneyPerCredit() * r.getSubjectGroup().getSubject().getCredit();
            }
        }
        return t;
    }
    public double getSeasonGradeAverage() {
        if(registerDTOS.size() == 0) return 0;
        double a = 0;
        int totalCredit = 0;
        for(int i = 0; i < registerDTOS.size(); i++) {
            RegisterDTO r = registerDTOS.get(i);
            if(r.getGrade() != null) {
                a += r.getSubjectGroup().getSubject().getCredit() *
                        r.getGrade().getAverageWithFourGrade().getValue();
                totalCredit += r.getSubjectGroup().getSubject().getCredit();
            }
        }
        return a/(totalCredit);
    }
}
