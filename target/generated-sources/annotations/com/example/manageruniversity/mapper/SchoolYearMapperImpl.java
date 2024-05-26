package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.entity.SchoolYear;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T10:58:30+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class SchoolYearMapperImpl implements SchoolYearMapper {

    @Override
    public SchoolYear schoolYearDTOToEntity(SchoolYearDTO schoolYearDTO) {
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

    @Override
    public SchoolYearDTO schoolYearToDTO(SchoolYear schoolYear) {
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
}
