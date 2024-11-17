package com.example.manageruniversity.university.instruction;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.object.ObjectUtils;
import com.example.manageruniversity.university.course.CourseDto;
import com.example.manageruniversity.university.major.MajorDto;
import com.example.manageruniversity.university.school_year.SchoolYearDto;
import com.example.manageruniversity.university.subject.SubjectDto;
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
