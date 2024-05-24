package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.Major;
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
    date = "2024-05-23T20:07:35+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class MajorMapperImpl implements MajorMapper {

    @Override
    public Major majorDTOToEntity(MajorDTO majorDTO) {
        if ( majorDTO == null ) {
            return null;
        }

        Major major = new Major();

        major.setId( majorDTO.getId() );
        major.setCreatedDate( majorDTO.getCreatedDate() );
        major.setCreatedBy( majorDTO.getCreatedBy() );
        major.setModifiedDate( majorDTO.getModifiedDate() );
        major.setModifiedBy( majorDTO.getModifiedBy() );
        major.setName( majorDTO.getName() );
        major.setSub( majorDTO.getSub() );

        return major;
    }

    @Override
    public MajorDTO majorToDTO(Major major) {
        if ( major == null ) {
            return null;
        }

        MajorDTO majorDTO = new MajorDTO();

        majorDTO.setMajorRegisterDTOS( majorRegisterListToMajorRegisterDTOList( major.getMajorRegisters() ) );
        majorDTO.setId( major.getId() );
        majorDTO.setCreatedDate( major.getCreatedDate() );
        majorDTO.setCreatedBy( major.getCreatedBy() );
        majorDTO.setModifiedDate( major.getModifiedDate() );
        majorDTO.setModifiedBy( major.getModifiedBy() );
        majorDTO.setName( major.getName() );
        majorDTO.setSub( major.getSub() );

        return majorDTO;
    }

    @Override
    public MajorRegisterDTO majorRegisterToDto(MajorRegister majorRegister) {
        if ( majorRegister == null ) {
            return null;
        }

        MajorRegisterDTO majorRegisterDTO = new MajorRegisterDTO();

        majorRegisterDTO.setSubjectDTOS( subjectListToSubjectDTOList( majorRegister.getSubjects() ) );
        majorRegisterDTO.setSeasonDTO( seasonToSeasonDTO( majorRegister.getSeason() ) );
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
            list1.add( majorRegisterToDto( majorRegister ) );
        }

        return list1;
    }

    protected SubjectDTO subjectToSubjectDTO(Subject subject) {
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

    protected List<SubjectDTO> subjectListToSubjectDTOList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectDTO> list1 = new ArrayList<SubjectDTO>( list.size() );
        for ( Subject subject : list ) {
            list1.add( subjectToSubjectDTO( subject ) );
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

    protected SeasonDTO seasonToSeasonDTO(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonDTO seasonDTO = new SeasonDTO();

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
}
