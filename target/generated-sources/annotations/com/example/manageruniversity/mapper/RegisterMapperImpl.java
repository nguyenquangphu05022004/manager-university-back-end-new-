package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.GradeDTO;
import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.dto.UserDTO;
import com.example.manageruniversity.entity.ComponentGrade;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.Grade;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Student;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.entity.Time;
import com.example.manageruniversity.entity.auth.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-28T10:37:07+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class RegisterMapperImpl implements RegisterMapper {

    @Override
    public RegisterDTO registerToDTO(Register register) {
        if ( register == null ) {
            return null;
        }

        RegisterDTO registerDTO = new RegisterDTO();

        registerDTO.setSubjectGroup( subjectGroupToSubjectGroupDTO( register.getSubjectGroup() ) );
        registerDTO.setStudentDTO( studentToStudentDTO( register.getStudent() ) );
        registerDTO.setId( register.getId() );
        registerDTO.setCreatedDate( register.getCreatedDate() );
        registerDTO.setCreatedBy( register.getCreatedBy() );
        registerDTO.setModifiedDate( register.getModifiedDate() );
        registerDTO.setModifiedBy( register.getModifiedBy() );
        registerDTO.setOpenTransaction( register.isOpenTransaction() );
        registerDTO.setGrade( gradeToGradeDTO( register.getGrade() ) );

        return registerDTO;
    }

    @Override
    public Register registerDTOToEntity(RegisterDTO registerDTO) {
        if ( registerDTO == null ) {
            return null;
        }

        Register register = new Register();

        register.setStudent( studentDTOToStudent( registerDTO.getStudentDTO() ) );
        register.setSubjectGroup( subjectGroupDTOToSubjectGroup( registerDTO.getSubjectGroup() ) );
        register.setMajorRegister( majorRegisterDTOToMajorRegister( registerDTO.getMajorRegisterDTO() ) );
        register.setId( registerDTO.getId() );
        register.setCreatedDate( registerDTO.getCreatedDate() );
        register.setCreatedBy( registerDTO.getCreatedBy() );
        register.setModifiedDate( registerDTO.getModifiedDate() );
        register.setModifiedBy( registerDTO.getModifiedBy() );
        register.setGrade( gradeDTOToGrade( registerDTO.getGrade() ) );
        register.setOpenTransaction( registerDTO.isOpenTransaction() );

        return register;
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

    protected SubjectGroupDTO subjectGroupToSubjectGroupDTO(SubjectGroup subjectGroup) {
        if ( subjectGroup == null ) {
            return null;
        }

        SubjectGroupDTO subjectGroupDTO = new SubjectGroupDTO();

        subjectGroupDTO.setSubject( subjectToSubjectDTO( subjectGroup.getSubject() ) );
        subjectGroupDTO.setId( subjectGroup.getId() );
        subjectGroupDTO.setCreatedDate( subjectGroup.getCreatedDate() );
        subjectGroupDTO.setCreatedBy( subjectGroup.getCreatedBy() );
        subjectGroupDTO.setModifiedDate( subjectGroup.getModifiedDate() );
        subjectGroupDTO.setModifiedBy( subjectGroup.getModifiedBy() );
        subjectGroupDTO.setGroupName( subjectGroup.getGroupName() );
        subjectGroupDTO.setTeacher( teacherToTeacherDTO( subjectGroup.getTeacher() ) );
        subjectGroupDTO.setNumberOfStudent( subjectGroup.getNumberOfStudent() );
        subjectGroupDTO.setTimes( timeListToTimeDTOList( subjectGroup.getTimes() ) );
        subjectGroupDTO.setNumberOfStudentCurrent( subjectGroup.getNumberOfStudentCurrent() );

        return subjectGroupDTO;
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

    protected StudentDTO studentToStudentDTO(Student student) {
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

    protected ComponentGradeDTO componentGradeToComponentGradeDTO(ComponentGrade componentGrade) {
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

    protected GradeDTO gradeToGradeDTO(Grade grade) {
        if ( grade == null ) {
            return null;
        }

        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setAttend( grade.getAttend() );
        gradeDTO.setMidtermTest( grade.getMidtermTest() );
        gradeDTO.setFinalTest( grade.getFinalTest() );
        gradeDTO.setPracticeTest( grade.getPracticeTest() );
        gradeDTO.setComponentGrade( componentGradeToComponentGradeDTO( grade.getComponentGrade() ) );

        return gradeDTO;
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

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDTO.getId() );
        student.setCreatedDate( studentDTO.getCreatedDate() );
        student.setCreatedBy( studentDTO.getCreatedBy() );
        student.setModifiedDate( studentDTO.getModifiedDate() );
        student.setModifiedBy( studentDTO.getModifiedBy() );
        student.setFullName( studentDTO.getFullName() );
        student.setAddress( studentDTO.getAddress() );
        student.setPhoneNumber( studentDTO.getPhoneNumber() );
        student.setDateOfBirth( studentDTO.getDateOfBirth() );
        student.setSex( studentDTO.getSex() );
        student.setMajor( majorDTOToMajor( studentDTO.getMajor() ) );
        student.setCourses( coursesDTOToCourses( studentDTO.getCourses() ) );
        student.setUser( userDTOToUser( studentDTO.getUser() ) );

        return student;
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

    protected SubjectGroup subjectGroupDTOToSubjectGroup(SubjectGroupDTO subjectGroupDTO) {
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

    protected MajorRegister majorRegisterDTOToMajorRegister(MajorRegisterDTO majorRegisterDTO) {
        if ( majorRegisterDTO == null ) {
            return null;
        }

        MajorRegister majorRegister = new MajorRegister();

        majorRegister.setId( majorRegisterDTO.getId() );
        majorRegister.setCreatedDate( majorRegisterDTO.getCreatedDate() );
        majorRegister.setCreatedBy( majorRegisterDTO.getCreatedBy() );
        majorRegister.setModifiedDate( majorRegisterDTO.getModifiedDate() );
        majorRegister.setModifiedBy( majorRegisterDTO.getModifiedBy() );

        return majorRegister;
    }

    protected ComponentGrade componentGradeDTOToComponentGrade(ComponentGradeDTO componentGradeDTO) {
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

    protected Grade gradeDTOToGrade(GradeDTO gradeDTO) {
        if ( gradeDTO == null ) {
            return null;
        }

        Grade grade = new Grade();

        grade.setAttend( gradeDTO.getAttend() );
        grade.setMidtermTest( gradeDTO.getMidtermTest() );
        grade.setFinalTest( gradeDTO.getFinalTest() );
        grade.setPracticeTest( gradeDTO.getPracticeTest() );
        grade.setComponentGrade( componentGradeDTOToComponentGrade( gradeDTO.getComponentGrade() ) );

        return grade;
    }
}
