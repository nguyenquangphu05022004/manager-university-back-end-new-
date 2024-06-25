package com.example.manageruniversity.dto;

import com.example.manageruniversity.utils.SystemUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AspirationRegisterDTO extends BaseDTO{
    private SeasonDTO season;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<SubjectApproval> subjectApprovals;
    public boolean getOpenRegister() {
        LocalDateTime now = LocalDateTime.now();
        if (start.isAfter(now)) return false;
        else if (now.isBefore(end)) return true;
        return false;
    }
    public String getFormatStart() {
        return start.format(SystemUtils.PATTERN_DATE_VIE);
    }

    public String getFormatEnd() {
        return end.format(SystemUtils.PATTERN_DATE_VIE);
    }

    @Getter
    @AllArgsConstructor
    public static class SubjectApproval {
        private SubjectDTO subject;
        private Boolean approval;
    }

}
