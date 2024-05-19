package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.EventRegisterDTO;
import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.EventRegister;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.SchoolYear;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Semester;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T16:00:59+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class EventRegisterMapperImpl implements EventRegisterMapper {

    @Override
    public EventRegister toEntity(EventRegisterDTO event) {
        if ( event == null ) {
            return null;
        }

        EventRegister eventRegister = new EventRegister();

        eventRegister.setMajors( majorDTOListToMajorList( event.getMajorDTOS() ) );
        eventRegister.setSeason( seasonDTOToSeason( event.getSeasonDTO() ) );
        eventRegister.setId( event.getId() );
        eventRegister.setCreatedDate( event.getCreatedDate() );
        eventRegister.setCreatedBy( event.getCreatedBy() );
        eventRegister.setModifiedDate( event.getModifiedDate() );
        eventRegister.setModifiedBy( event.getModifiedBy() );
        eventRegister.setStart( event.getStart() );
        eventRegister.setIntervalDay( event.getIntervalDay() );
        eventRegister.setExpired( event.isExpired() );

        return eventRegister;
    }

    @Override
    public EventRegisterDTO toDto(EventRegister event) {
        if ( event == null ) {
            return null;
        }

        EventRegisterDTO eventRegisterDTO = new EventRegisterDTO();

        eventRegisterDTO.setMajorDTOS( majorListToMajorDTOList( event.getMajors() ) );
        eventRegisterDTO.setSeasonDTO( seasonToSeasonDTO( event.getSeason() ) );
        eventRegisterDTO.setId( event.getId() );
        eventRegisterDTO.setCreatedDate( event.getCreatedDate() );
        eventRegisterDTO.setCreatedBy( event.getCreatedBy() );
        eventRegisterDTO.setModifiedDate( event.getModifiedDate() );
        eventRegisterDTO.setModifiedBy( event.getModifiedBy() );
        eventRegisterDTO.setStart( event.getStart() );
        eventRegisterDTO.setIntervalDay( event.getIntervalDay() );
        eventRegisterDTO.setExpired( event.isExpired() );

        return eventRegisterDTO;
    }

    protected Major majorDTOToMajor(MajorDTO majorDTO) {
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

    protected List<Major> majorDTOListToMajorList(List<MajorDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Major> list1 = new ArrayList<Major>( list.size() );
        for ( MajorDTO majorDTO : list ) {
            list1.add( majorDTOToMajor( majorDTO ) );
        }

        return list1;
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

    protected Season seasonDTOToSeason(SeasonDTO seasonDTO) {
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

    protected MajorDTO majorToMajorDTO(Major major) {
        if ( major == null ) {
            return null;
        }

        MajorDTO majorDTO = new MajorDTO();

        majorDTO.setId( major.getId() );
        majorDTO.setCreatedDate( major.getCreatedDate() );
        majorDTO.setCreatedBy( major.getCreatedBy() );
        majorDTO.setModifiedDate( major.getModifiedDate() );
        majorDTO.setModifiedBy( major.getModifiedBy() );
        majorDTO.setName( major.getName() );
        majorDTO.setSub( major.getSub() );

        return majorDTO;
    }

    protected List<MajorDTO> majorListToMajorDTOList(List<Major> list) {
        if ( list == null ) {
            return null;
        }

        List<MajorDTO> list1 = new ArrayList<MajorDTO>( list.size() );
        for ( Major major : list ) {
            list1.add( majorToMajorDTO( major ) );
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
