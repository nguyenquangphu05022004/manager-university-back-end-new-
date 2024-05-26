package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.entity.Teacher;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T10:58:30+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public Teacher teacherDTOToEntity(TeacherDTO teacherDTO) {
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

    @Override
    public TeacherDTO teacherToDTO(Teacher teacher) {
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
}
