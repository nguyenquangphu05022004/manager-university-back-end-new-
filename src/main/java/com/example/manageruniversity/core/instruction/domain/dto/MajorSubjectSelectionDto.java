package com.example.manageruniversity.core.instruction.domain.dto;

import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.course.domain.dto.CourseDto;
import com.example.manageruniversity.core.instruction.domain.entity.MajorSubjectSelection;
import com.example.manageruniversity.core.major.domain.dto.MajorDto;
import com.example.manageruniversity.core.schoolYear.domain.dto.SchoolYearDto;
import com.example.manageruniversity.core.subject.domain.dto.SubjectDto;
import lombok.Getter;

@Getter
public class MajorSubjectSelectionDto {
    private MajorDto major;
    private SchoolYearDto schoolYear;
    private SubjectDto subject;
    private CourseDto course;

    public MajorSubjectSelectionDto(MajorSubjectSelection majorSubjectSelection) {
        if(ObjectUtils.isNull(majorSubjectSelection)) return;
        this.major = new MajorDto(majorSubjectSelection.getMajor());
        this.schoolYear = new SchoolYearDto(majorSubjectSelection.getSchoolYear());
        this.subject = new SubjectDto(majorSubjectSelection.getSubject());
        this.course = new CourseDto(majorSubjectSelection.getCourse());
    }
}
