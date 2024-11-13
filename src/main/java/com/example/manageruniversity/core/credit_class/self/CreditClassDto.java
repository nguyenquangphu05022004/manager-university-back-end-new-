package com.example.manageruniversity.core.credit_class.self;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.core.credit_class.time_table.TimeTableDto;
import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.subject.SubjectDto;
import com.example.manageruniversity.core.member.domain.dto.response.TeacherDto;
import lombok.Data;

import java.util.List;

@Data
public class CreditClassDto {

    private Integer maxStudent;
    private TeacherDto teacher;

    private SubjectDto subject;

    private SchoolYearDto schoolYear;

    private Integer studyGroup;
    private List<TimeTableDto> timeTables;
    public CreditClassDto(CreditClass creditClass) {
        this.maxStudent =creditClass.getMaxStudent();
        this.teacher = new TeacherDto(creditClass.getTeacher());
        this.schoolYear = new SchoolYearDto(creditClass.getSchoolYear());
        this.studyGroup = creditClass.getStudyGroup();
        this.timeTables = ListUtils.convertToList(TimeTableDto.class, creditClass.getTimeTables());
    }
}
