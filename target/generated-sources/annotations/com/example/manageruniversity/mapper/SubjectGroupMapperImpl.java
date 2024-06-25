package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.entity.Time;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T22:16:11+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class SubjectGroupMapperImpl implements SubjectGroupMapper {

    @Override
    public SubjectGroup subjectGroupDTOToEntity(SubjectGroupDTO subjectGroupDTO) {
        if ( subjectGroupDTO == null ) {
            return null;
        }

        SubjectGroup subjectGroup = new SubjectGroup();

        subjectGroup.setId( subjectGroupDTO.getId() );
        subjectGroup.setCreatedDate( subjectGroupDTO.getCreatedDate() );
        subjectGroup.setCreatedBy( subjectGroupDTO.getCreatedBy() );
        subjectGroup.setModifiedDate( subjectGroupDTO.getModifiedDate() );
        subjectGroup.setModifiedBy( subjectGroupDTO.getModifiedBy() );
        subjectGroup.setGroupName( subjectGroupDTO.getGroupName() );
        subjectGroup.setSubject( subjectDTOToSubject( subjectGroupDTO.getSubject() ) );
        subjectGroup.setNumberOfStudent( subjectGroupDTO.getNumberOfStudent() );
        subjectGroup.setTimes( timeDTOListToTimeList( subjectGroupDTO.getTimes() ) );
        subjectGroup.setTeacher( teacherDTOToTeacher( subjectGroupDTO.getTeacher() ) );
        subjectGroup.setNumberOfStudentCurrent( subjectGroupDTO.getNumberOfStudentCurrent() );

        return subjectGroup;
    }

    @Override
    public SubjectGroupDTO subjectGroupToDTO(SubjectGroup subjectGroup) {
        if ( subjectGroup == null ) {
            return null;
        }

        SubjectGroupDTO subjectGroupDTO = new SubjectGroupDTO();

        subjectGroupDTO.setId( subjectGroup.getId() );
        subjectGroupDTO.setCreatedDate( subjectGroup.getCreatedDate() );
        subjectGroupDTO.setCreatedBy( subjectGroup.getCreatedBy() );
        subjectGroupDTO.setModifiedDate( subjectGroup.getModifiedDate() );
        subjectGroupDTO.setModifiedBy( subjectGroup.getModifiedBy() );
        subjectGroupDTO.setGroupName( subjectGroup.getGroupName() );
        subjectGroupDTO.setSubject( subjectToSubjectDTO( subjectGroup.getSubject() ) );
        subjectGroupDTO.setTeacher( teacherToTeacherDTO( subjectGroup.getTeacher() ) );
        subjectGroupDTO.setNumberOfStudent( subjectGroup.getNumberOfStudent() );
        subjectGroupDTO.setTimes( timeListToTimeDTOList( subjectGroup.getTimes() ) );
        subjectGroupDTO.setNumberOfStudentCurrent( subjectGroup.getNumberOfStudentCurrent() );

        return subjectGroupDTO;
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setId( subjectDTO.getId() );
        subject.setCreatedDate( subjectDTO.getCreatedDate() );
        subject.setCreatedBy( subjectDTO.getCreatedBy() );
        subject.setModifiedDate( subjectDTO.getModifiedDate() );
        subject.setModifiedBy( subjectDTO.getModifiedBy() );
        subject.setSubjectName( subjectDTO.getSubjectName() );
        subject.setSubjectCode( subjectDTO.getSubjectCode() );
        subject.setCredit( subjectDTO.getCredit() );

        return subject;
    }

    protected RoomClass roomClassDTOToRoomClass(RoomClassDTO roomClassDTO) {
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

    protected Time timeDTOToTime(TimeDTO timeDTO) {
        if ( timeDTO == null ) {
            return null;
        }

        Time time = new Time();

        time.setId( timeDTO.getId() );
        time.setCreatedDate( timeDTO.getCreatedDate() );
        time.setCreatedBy( timeDTO.getCreatedBy() );
        time.setModifiedDate( timeDTO.getModifiedDate() );
        time.setModifiedBy( timeDTO.getModifiedBy() );
        time.setDayOfWeek( timeDTO.getDayOfWeek() );
        time.setStartTime( timeDTO.getStartTime() );
        time.setEndTime( timeDTO.getEndTime() );
        time.setStartDate( timeDTO.getStartDate() );
        time.setEndDate( timeDTO.getEndDate() );
        time.setRoomClass( roomClassDTOToRoomClass( timeDTO.getRoomClass() ) );

        return time;
    }

    protected List<Time> timeDTOListToTimeList(List<TimeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Time> list1 = new ArrayList<Time>( list.size() );
        for ( TimeDTO timeDTO : list ) {
            list1.add( timeDTOToTime( timeDTO ) );
        }

        return list1;
    }

    protected Teacher teacherDTOToTeacher(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDTO.getId() );
        teacher.setCreatedDate( teacherDTO.getCreatedDate() );
        teacher.setCreatedBy( teacherDTO.getCreatedBy() );
        teacher.setModifiedDate( teacherDTO.getModifiedDate() );
        teacher.setModifiedBy( teacherDTO.getModifiedBy() );
        teacher.setFullName( teacherDTO.getFullName() );
        teacher.setAddress( teacherDTO.getAddress() );
        teacher.setPhoneNumber( teacherDTO.getPhoneNumber() );
        teacher.setDateOfBirth( teacherDTO.getDateOfBirth() );
        teacher.setSex( teacherDTO.getSex() );

        return teacher;
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

    protected TeacherDTO teacherToTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId( teacher.getId() );
        teacherDTO.setCreatedDate( teacher.getCreatedDate() );
        teacherDTO.setCreatedBy( teacher.getCreatedBy() );
        teacherDTO.setModifiedDate( teacher.getModifiedDate() );
        teacherDTO.setModifiedBy( teacher.getModifiedBy() );
        teacherDTO.setFullName( teacher.getFullName() );
        teacherDTO.setAddress( teacher.getAddress() );
        teacherDTO.setPhoneNumber( teacher.getPhoneNumber() );
        teacherDTO.setDateOfBirth( teacher.getDateOfBirth() );
        teacherDTO.setSex( teacher.getSex() );

        return teacherDTO;
    }

    protected RoomClassDTO roomClassToRoomClassDTO(RoomClass roomClass) {
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
        timeDTO.setRoomClass( roomClassToRoomClassDTO( time.getRoomClass() ) );

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
