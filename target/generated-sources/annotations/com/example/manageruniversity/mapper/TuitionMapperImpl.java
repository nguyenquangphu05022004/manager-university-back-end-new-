package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.Tuition;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-23T20:07:34+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class TuitionMapperImpl implements TuitionMapper {

    @Override
    public TuitionDTO entityToDto(Tuition tuition) {
        if ( tuition == null ) {
            return null;
        }

        TuitionDTO tuitionDTO = new TuitionDTO();

        tuitionDTO.setId( tuition.getId() );
        tuitionDTO.setCreatedDate( tuition.getCreatedDate() );
        tuitionDTO.setCreatedBy( tuition.getCreatedBy() );
        tuitionDTO.setModifiedDate( tuition.getModifiedDate() );
        tuitionDTO.setModifiedBy( tuition.getModifiedBy() );
        tuitionDTO.setMoneyPerCredit( tuition.getMoneyPerCredit() );

        return tuitionDTO;
    }

    @Override
    public Tuition dtoToEntity(TuitionDTO tuitionDTO) {
        if ( tuitionDTO == null ) {
            return null;
        }

        Tuition tuition = new Tuition();

        tuition.setId( tuitionDTO.getId() );
        tuition.setCreatedDate( tuitionDTO.getCreatedDate() );
        tuition.setCreatedBy( tuitionDTO.getCreatedBy() );
        tuition.setModifiedDate( tuitionDTO.getModifiedDate() );
        tuition.setModifiedBy( tuitionDTO.getModifiedBy() );
        tuition.setMoneyPerCredit( tuitionDTO.getMoneyPerCredit() );

        return tuition;
    }
}
