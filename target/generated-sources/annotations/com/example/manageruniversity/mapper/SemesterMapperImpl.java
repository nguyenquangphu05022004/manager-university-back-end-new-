package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.entity.Semester;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T10:37:07+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class SemesterMapperImpl implements SemesterMapper {

    @Override
    public Semester semesterDTOToEntity(SemesterDTO semesterDTO) {
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

    @Override
    public SemesterDTO semesterToDTO(Semester semester) {
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
}
