package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.entity.SchoolYear;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Semester;
import com.example.manageruniversity.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-23T20:07:34+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class SeasonMapperImpl implements SeasonMapper {

    @Override
    public Season seasonDTOToEntity(SeasonDTO seasonDTO) {
        if ( seasonDTO == null ) {
            return null;
        }

        Season season = new Season();

        season.setId( seasonDTO.getId() );
        season.setCreatedDate( seasonDTO.getCreatedDate() );
        season.setCreatedBy( seasonDTO.getCreatedBy() );
        season.setModifiedDate( seasonDTO.getModifiedDate() );
        season.setModifiedBy( seasonDTO.getModifiedBy() );
        season.setSemester( semesterDTOToSemester( seasonDTO.getSemester() ) );
        season.setSchoolYear( schoolYearDTOToSchoolYear( seasonDTO.getSchoolYear() ) );
        season.setCourses( coursesDTOToCourses( seasonDTO.getCourses() ) );
        season.setDisabled( seasonDTO.isDisabled() );

        return season;
    }

    @Override
    public SeasonDTO seasonToDTO(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonDTO seasonDTO = new SeasonDTO();

        seasonDTO.setMajorRegisterDTOS( majorRegisterListToMajorRegisterDTOList( season.getMajorRegisters() ) );
        seasonDTO.setId( season.getId() );
        seasonDTO.setCreatedDate( season.getCreatedDate() );
        seasonDTO.setCreatedBy( season.getCreatedBy() );
        seasonDTO.setModifiedDate( season.getModifiedDate() );
        seasonDTO.setModifiedBy( season.getModifiedBy() );
        seasonDTO.setSemester( semesterToSemesterDTO( season.getSemester() ) );
        seasonDTO.setSchoolYear( schoolYearToSchoolYearDTO( season.getSchoolYear() ) );
        seasonDTO.setCourses( coursesToCoursesDTO( season.getCourses() ) );
        seasonDTO.setDisabled( season.isDisabled() );

        return seasonDTO;
    }

    @Override
    public SubjectDTO subjectToDto(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setId( subject.getId() );
        subjectDTO.setCreatedDate( subject.getCreatedDate() );
        subjectDTO.setCreatedBy( subject.getCreatedBy() );
        subjectDTO.setModifiedDate( subject.getModifiedDate() );
        subjectDTO.setModifiedBy( subject.getModifiedBy() );
        subjectDTO.setSubjectName( subject.getSubjectName() );
        subjectDTO.setSubjectCode( subject.getSubjectCode() );
        subjectDTO.setCredit( subject.getCredit() );

        return subjectDTO;
    }

    protected Semester semesterDTOToSemester(SemesterDTO semesterDTO) {
        if ( semesterDTO == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setId( semesterDTO.getId() );
        semester.setCreatedDate( semesterDTO.getCreatedDate() );
        semester.setCreatedBy( semesterDTO.getCreatedBy() );
        semester.setModifiedDate( semesterDTO.getModifiedDate() );
        semester.setModifiedBy( semesterDTO.getModifiedBy() );
        semester.setSemesterName( semesterDTO.getSemesterName() );

        return semester;
    }

    protected SchoolYear schoolYearDTOToSchoolYear(SchoolYearDTO schoolYearDTO) {
        if ( schoolYearDTO == null ) {
            return null;
        }

        SchoolYear schoolYear = new SchoolYear();

        schoolYear.setId( schoolYearDTO.getId() );
        schoolYear.setCreatedDate( schoolYearDTO.getCreatedDate() );
        schoolYear.setCreatedBy( schoolYearDTO.getCreatedBy() );
        schoolYear.setModifiedDate( schoolYearDTO.getModifiedDate() );
        schoolYear.setModifiedBy( schoolYearDTO.getModifiedBy() );
        schoolYear.setName( schoolYearDTO.getName() );

        return schoolYear;
    }

    protected Courses coursesDTOToCourses(CoursesDTO coursesDTO) {
        if ( coursesDTO == null ) {
            return null;
        }

        Courses courses = new Courses();

        courses.setId( coursesDTO.getId() );
        courses.setCreatedDate( coursesDTO.getCreatedDate() );
        courses.setCreatedBy( coursesDTO.getCreatedBy() );
        courses.setModifiedDate( coursesDTO.getModifiedDate() );
        courses.setModifiedBy( coursesDTO.getModifiedBy() );
        courses.setName( coursesDTO.getName() );
        courses.setCode( coursesDTO.getCode() );

        return courses;
    }

    protected MajorRegisterDTO majorRegisterToMajorRegisterDTO(MajorRegister majorRegister) {
        if ( majorRegister == null ) {
            return null;
        }

        MajorRegisterDTO majorRegisterDTO = new MajorRegisterDTO();

        majorRegisterDTO.setId( majorRegister.getId() );
        majorRegisterDTO.setCreatedDate( majorRegister.getCreatedDate() );
        majorRegisterDTO.setCreatedBy( majorRegister.getCreatedBy() );
        majorRegisterDTO.setModifiedDate( majorRegister.getModifiedDate() );
        majorRegisterDTO.setModifiedBy( majorRegister.getModifiedBy() );
        majorRegisterDTO.setOpenRegister( majorRegister.isOpenRegister() );

        return majorRegisterDTO;
    }

    protected List<MajorRegisterDTO> majorRegisterListToMajorRegisterDTOList(List<MajorRegister> list) {
        if ( list == null ) {
            return null;
        }

        List<MajorRegisterDTO> list1 = new ArrayList<MajorRegisterDTO>( list.size() );
        for ( MajorRegister majorRegister : list ) {
            list1.add( majorRegisterToMajorRegisterDTO( majorRegister ) );
        }

        return list1;
    }

    protected SemesterDTO semesterToSemesterDTO(Semester semester) {
        if ( semester == null ) {
            return null;
        }

        SemesterDTO semesterDTO = new SemesterDTO();

        semesterDTO.setId( semester.getId() );
        semesterDTO.setCreatedDate( semester.getCreatedDate() );
        semesterDTO.setCreatedBy( semester.getCreatedBy() );
        semesterDTO.setModifiedDate( semester.getModifiedDate() );
        semesterDTO.setModifiedBy( semester.getModifiedBy() );
        semesterDTO.setSemesterName( semester.getSemesterName() );

        return semesterDTO;
    }

    protected SchoolYearDTO schoolYearToSchoolYearDTO(SchoolYear schoolYear) {
        if ( schoolYear == null ) {
            return null;
        }

        SchoolYearDTO schoolYearDTO = new SchoolYearDTO();

        schoolYearDTO.setId( schoolYear.getId() );
        schoolYearDTO.setCreatedDate( schoolYear.getCreatedDate() );
        schoolYearDTO.setCreatedBy( schoolYear.getCreatedBy() );
        schoolYearDTO.setModifiedDate( schoolYear.getModifiedDate() );
        schoolYearDTO.setModifiedBy( schoolYear.getModifiedBy() );
        schoolYearDTO.setName( schoolYear.getName() );

        return schoolYearDTO;
    }

    protected CoursesDTO coursesToCoursesDTO(Courses courses) {
        if ( courses == null ) {
            return null;
        }

        CoursesDTO coursesDTO = new CoursesDTO();

        coursesDTO.setId( courses.getId() );
        coursesDTO.setCreatedDate( courses.getCreatedDate() );
        coursesDTO.setCreatedBy( courses.getCreatedBy() );
        coursesDTO.setModifiedDate( courses.getModifiedDate() );
        coursesDTO.setModifiedBy( courses.getModifiedBy() );
        coursesDTO.setName( courses.getName() );
        coursesDTO.setCode( courses.getCode() );

        return coursesDTO;
    }
}
