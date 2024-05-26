package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.dto.UserDTO;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.Student;
import com.example.manageruniversity.entity.auth.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-26T10:58:30+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student studentDTOToEntity(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( dto.getId() );
        student.setCreatedDate( dto.getCreatedDate() );
        student.setCreatedBy( dto.getCreatedBy() );
        student.setModifiedDate( dto.getModifiedDate() );
        student.setModifiedBy( dto.getModifiedBy() );
        student.setFullName( dto.getFullName() );
        student.setAddress( dto.getAddress() );
        student.setPhoneNumber( dto.getPhoneNumber() );
        student.setDateOfBirth( dto.getDateOfBirth() );
        student.setSex( dto.getSex() );
        student.setMajor( majorDTOToMajor( dto.getMajor() ) );
        student.setCourses( coursesDTOToCourses( dto.getCourses() ) );
        student.setUser( userDTOToUser( dto.getUser() ) );

        return student;
    }

    @Override
    public StudentDTO studentToDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setCreatedDate( student.getCreatedDate() );
        studentDTO.setCreatedBy( student.getCreatedBy() );
        studentDTO.setModifiedDate( student.getModifiedDate() );
        studentDTO.setModifiedBy( student.getModifiedBy() );
        studentDTO.setFullName( student.getFullName() );
        studentDTO.setAddress( student.getAddress() );
        studentDTO.setPhoneNumber( student.getPhoneNumber() );
        studentDTO.setDateOfBirth( student.getDateOfBirth() );
        studentDTO.setSex( student.getSex() );
        studentDTO.setMajor( majorToMajorDTO( student.getMajor() ) );
        studentDTO.setCourses( coursesToCoursesDTO( student.getCourses() ) );
        studentDTO.setUser( userToUserDTO( student.getUser() ) );

        return studentDTO;
    }

    protected Major majorDTOToMajor(MajorDTO majorDTO) {
        if ( majorDTO == null ) {
            return null;
        }

        Major major = new Major();

        major.setId( majorDTO.getId() );
        major.setCreatedDate( majorDTO.getCreatedDate() );
        major.setCreatedBy( majorDTO.getCreatedBy() );
        major.setModifiedDate( majorDTO.getModifiedDate() );
        major.setModifiedBy( majorDTO.getModifiedBy() );
        major.setName( majorDTO.getName() );
        major.setSub( majorDTO.getSub() );

        return major;
    }

    protected Courses coursesDTOToCourses(CoursesDTO coursesDTO) {
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

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userDTO.getUsername() );
        user.role( userDTO.getRole() );

        return user.build();
    }

    protected MajorDTO majorToMajorDTO(Major major) {
        if ( major == null ) {
            return null;
        }

        MajorDTO majorDTO = new MajorDTO();

        majorDTO.setId( major.getId() );
        majorDTO.setCreatedDate( major.getCreatedDate() );
        majorDTO.setCreatedBy( major.getCreatedBy() );
        majorDTO.setModifiedDate( major.getModifiedDate() );
        majorDTO.setModifiedBy( major.getModifiedBy() );
        majorDTO.setName( major.getName() );
        majorDTO.setSub( major.getSub() );

        return majorDTO;
    }

    protected CoursesDTO coursesToCoursesDTO(Courses courses) {
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

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.username( user.getUsername() );
        userDTO.role( user.getRole() );

        return userDTO.build();
    }
}
