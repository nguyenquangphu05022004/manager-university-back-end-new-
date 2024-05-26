package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.entity.ComponentGrade;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T10:58:31+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ComponentGradeMapperImpl implements ComponentGradeMapper {

    @Override
    public ComponentGrade toEntity(ComponentGradeDTO componentGradeDTO) {
        if ( componentGradeDTO == null ) {
            return null;
        }

        ComponentGrade componentGrade = new ComponentGrade();

        componentGrade.setId( componentGradeDTO.getId() );
        componentGrade.setCreatedDate( componentGradeDTO.getCreatedDate() );
        componentGrade.setCreatedBy( componentGradeDTO.getCreatedBy() );
        componentGrade.setModifiedDate( componentGradeDTO.getModifiedDate() );
        componentGrade.setModifiedBy( componentGradeDTO.getModifiedBy() );
        componentGrade.setAttend( componentGradeDTO.getAttend() );
        componentGrade.setMidtermTest( componentGradeDTO.getMidtermTest() );
        componentGrade.setFinalTest( componentGradeDTO.getFinalTest() );
        componentGrade.setPracticeTest( componentGradeDTO.getPracticeTest() );

        return componentGrade;
    }

    @Override
    public ComponentGradeDTO toDto(ComponentGrade componentGrade) {
        if ( componentGrade == null ) {
            return null;
        }

        ComponentGradeDTO componentGradeDTO = new ComponentGradeDTO();

        componentGradeDTO.setId( componentGrade.getId() );
        componentGradeDTO.setCreatedDate( componentGrade.getCreatedDate() );
        componentGradeDTO.setCreatedBy( componentGrade.getCreatedBy() );
        componentGradeDTO.setModifiedDate( componentGrade.getModifiedDate() );
        componentGradeDTO.setModifiedBy( componentGrade.getModifiedBy() );
        componentGradeDTO.setAttend( componentGrade.getAttend() );
        componentGradeDTO.setMidtermTest( componentGrade.getMidtermTest() );
        componentGradeDTO.setFinalTest( componentGrade.getFinalTest() );
        componentGradeDTO.setPracticeTest( componentGrade.getPracticeTest() );

        return componentGradeDTO;
    }
}
