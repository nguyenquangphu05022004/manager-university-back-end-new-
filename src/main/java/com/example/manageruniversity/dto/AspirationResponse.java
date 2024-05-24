package com.example.manageruniversity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AspirationResponse extends BaseDTO{
    private SubjectDTO subject;
    private StudentDTO student;
    private boolean approval;
    public String getMessage() {
        if(approval) {
            return "Đã xem xét và số lượng sinh viên lớn hơn mong đợi => Mở lớp";
        }
        return "Đã xem xét và số lượng sinh viên nhỏ hơn mong đợi => Lớp không được mở";
    }
}
