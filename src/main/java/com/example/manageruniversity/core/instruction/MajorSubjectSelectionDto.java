package com.example.manageruniversity.core.instruction;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.core.course.CourseDto;
import com.example.manageruniversity.core.major.MajorDto;
import com.example.manageruniversity.core.school_year.SchoolYearDto;
import com.example.manageruniversity.core.subject.SubjectDto;
import lombok.Getter;

import java.util.List;

@Getter
public class MajorSubjectSelectionDto {
    private Long id;
    private MajorDto major;
    private SchoolYearDto schoolYear;
    private List<SubjectDto> subject;
    private CourseDto course;

    public MajorSubjectSelectionDto(MajorSubjectSelection majorSubjectSelection) {
        if(ObjectUtils.isNull(majorSubjectSelection)) return;
        this.id = majorSubjectSelection.getId();
        this.major = new MajorDto(majorSubjectSelection.getMajor());
        this.schoolYear = new SchoolYearDto(majorSubjectSelection.getSchoolYear());
        this.subject = ListUtils.convertToList(majorSubjectSelection.getSubjects(),SubjectDto::new);
        this.course = new CourseDto(majorSubjectSelection.getCourse());
    }
}
