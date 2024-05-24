package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.Subject;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-23T20:07:33+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public Subject subjectDTOToEntity(SubjectDTO subjectDTO) {
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

    @Override
    public SubjectDTO subjectToDTO(Subject subject) {
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
}
