package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.entity.Courses;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T10:58:30+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class CoursesMapperImpl implements CoursesMapper {

    @Override
    public CoursesDTO coursesToDTO(Courses courses) {
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

    @Override
    public Courses coursesDTOtoEntity(CoursesDTO coursesDTO) {
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
}
