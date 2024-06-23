package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.AspirationRegisterDTO;
import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.entity.AspirationRegister;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.SchoolYear;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Semester;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T10:38:19+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class AspirationRegisterMapperImpl implements AspirationRegisterMapper {

    @Override
    public AspirationRegisterDTO mapToDto(AspirationRegister aspirationRegister) {
        if ( aspirationRegister == null ) {
            return null;
        }

        AspirationRegisterDTO aspirationRegisterDTO = new AspirationRegisterDTO();

        aspirationRegisterDTO.setSeason( seasonToSeasonDTO( aspirationRegister.getSeason() ) );
        aspirationRegisterDTO.setStart( aspirationRegister.getStart() );
        aspirationRegisterDTO.setEnd( aspirationRegister.getEnd() );

        return aspirationRegisterDTO;
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
