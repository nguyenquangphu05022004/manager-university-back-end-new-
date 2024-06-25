package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.entity.RoomClass;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T22:16:11+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class RoomClassMapperImpl implements RoomClassMapper {

    @Override
    public RoomClass roomClassDTOToEntity(RoomClassDTO roomClassDTO) {
        if ( roomClassDTO == null ) {
            return null;
        }

        RoomClass roomClass = new RoomClass();

        roomClass.setId( roomClassDTO.getId() );
        roomClass.setCreatedDate( roomClassDTO.getCreatedDate() );
        roomClass.setCreatedBy( roomClassDTO.getCreatedBy() );
        roomClass.setModifiedDate( roomClassDTO.getModifiedDate() );
        roomClass.setModifiedBy( roomClassDTO.getModifiedBy() );
        roomClass.setName( roomClassDTO.getName() );

        return roomClass;
    }

    @Override
    public RoomClassDTO roomClassToDTO(RoomClass roomClass) {
        if ( roomClass == null ) {
            return null;
        }

        RoomClassDTO roomClassDTO = new RoomClassDTO();

        roomClassDTO.setId( roomClass.getId() );
        roomClassDTO.setCreatedDate( roomClass.getCreatedDate() );
        roomClassDTO.setCreatedBy( roomClass.getCreatedBy() );
        roomClassDTO.setModifiedDate( roomClass.getModifiedDate() );
        roomClassDTO.setModifiedBy( roomClass.getModifiedBy() );
        roomClassDTO.setName( roomClass.getName() );

        return roomClassDTO;
    }
}
