package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Time;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T16:00:59+0700",
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

        roomClassDTO.setTimeDTOS( timeListToTimeDTOList( roomClass.getTimes() ) );
        roomClassDTO.setId( roomClass.getId() );
        roomClassDTO.setCreatedDate( roomClass.getCreatedDate() );
        roomClassDTO.setCreatedBy( roomClass.getCreatedBy() );
        roomClassDTO.setModifiedDate( roomClass.getModifiedDate() );
        roomClassDTO.setModifiedBy( roomClass.getModifiedBy() );
        roomClassDTO.setName( roomClass.getName() );

        return roomClassDTO;
    }

    protected TimeDTO timeToTimeDTO(Time time) {
        if ( time == null ) {
            return null;
        }

        TimeDTO timeDTO = new TimeDTO();

        timeDTO.setId( time.getId() );
        timeDTO.setCreatedDate( time.getCreatedDate() );
        timeDTO.setCreatedBy( time.getCreatedBy() );
        timeDTO.setModifiedDate( time.getModifiedDate() );
        timeDTO.setModifiedBy( time.getModifiedBy() );
        timeDTO.setDayOfWeek( time.getDayOfWeek() );
        timeDTO.setStartTime( time.getStartTime() );
        timeDTO.setEndTime( time.getEndTime() );
        timeDTO.setStartDate( time.getStartDate() );
        timeDTO.setEndDate( time.getEndDate() );

        return timeDTO;
    }

    protected List<TimeDTO> timeListToTimeDTOList(List<Time> list) {
        if ( list == null ) {
            return null;
        }

        List<TimeDTO> list1 = new ArrayList<TimeDTO>( list.size() );
        for ( Time time : list ) {
            list1.add( timeToTimeDTO( time ) );
        }

        return list1;
    }
}
