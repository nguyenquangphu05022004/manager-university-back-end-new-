package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.dto.EventRegisterResponse;
import com.example.manageruniversity.dto.GradeDTO;
import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.RegisterDTO;
import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.dto.TeacherDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.ComponentGrade;
import com.example.manageruniversity.entity.Courses;
import com.example.manageruniversity.entity.EventRegister;
import com.example.manageruniversity.entity.Grade;
import com.example.manageruniversity.entity.Major;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.SchoolYear;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Semester;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.SubjectGroup;
import com.example.manageruniversity.entity.Teacher;
import com.example.manageruniversity.entity.Time;
import com.example.manageruniversity.entity.Tuition;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T22:16:10+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class MajorRegisterMapperImpl implements MajorRegisterMapper {

    @Override
    public MajorRegister majorRegisterDTOToEntity(MajorRegisterDTO majorRegisterDTO) {
        if ( majorRegisterDTO == null ) {
            return null;
        }

        MajorRegister majorRegister = new MajorRegister();

        majorRegister.setMajor( majorDTOToMajor( majorRegisterDTO.getMajorDTO() ) );
        majorRegister.setSeason( seasonDTOToSeason( majorRegisterDTO.getSeasonDTO() ) );
        majorRegister.setSubjects( subjectDTOListToSubjectList( majorRegisterDTO.getSubjectDTOS() ) );
        majorRegister.setId( majorRegisterDTO.getId() );
        majorRegister.setCreatedDate( majorRegisterDTO.getCreatedDate() );
        majorRegister.setCreatedBy( majorRegisterDTO.getCreatedBy() );
        majorRegister.setModifiedDate( majorRegisterDTO.getModifiedDate() );
        majorRegister.setModifiedBy( majorRegisterDTO.getModifiedBy() );

        return majorRegister;
    }

    @Override
    public MajorRegisterDTO majorRegisterToDTO(MajorRegister majorRegister) {
        if ( majorRegister == null ) {
            return null;
        }

        MajorRegisterDTO majorRegisterDTO = new MajorRegisterDTO();

        majorRegisterDTO.setMajorDTO( majorToMajorDTO( majorRegister.getMajor() ) );
        majorRegisterDTO.setSeasonDTO( seasonToSeasonDTO( majorRegister.getSeason() ) );
        majorRegisterDTO.setSubjectDTOS( subjectListToSubjectDTOList( majorRegister.getSubjects() ) );
        majorRegisterDTO.setTuitionDTO( tuitionToTuitionDTO( majorRegister.getTuition() ) );
        majorRegisterDTO.setRegisterDTOS( registerListToRegisterDTOList( majorRegister.getRegisters() ) );
        majorRegisterDTO.setEventRegisterResponse( eventRegisterToEventRegisterResponse( majorRegister.getEventRegister() ) );
        majorRegisterDTO.setId( majorRegister.getId() );
        majorRegisterDTO.setCreatedDate( majorRegister.getCreatedDate() );
        majorRegisterDTO.setCreatedBy( majorRegister.getCreatedBy() );
        majorRegisterDTO.setModifiedDate( majorRegister.getModifiedDate() );
        majorRegisterDTO.setModifiedBy( majorRegister.getModifiedBy() );
        majorRegisterDTO.setOpenRegister( majorRegister.getOpenRegister() );

        return majorRegisterDTO;
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

    protected Semester semesterDTOToSemester(SemesterDTO semesterDTO) {
        if ( semesterDTO == null ) {
            return null;
        }

        Semester semester = new Semester();

        semester.setId( semesterDTO.getId() );
        semester.setCreatedDate( semesterDTO.getCreatedDate() );
        semester.setCreatedBy( semesterDTO.getCreatedBy() );
        semester.setModifiedDate( semesterDTO.getModifiedDate() );
        semester.setModifiedBy( semesterDTO.getModifiedBy() );
        semester.setSemesterName( semesterDTO.getSemesterName() );

        return semester;
    }

    protected SchoolYear schoolYearDTOToSchoolYear(SchoolYearDTO schoolYearDTO) {
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

    protected Season seasonDTOToSeason(SeasonDTO seasonDTO) {
        if ( seasonDTO == null ) {
            return null;
        }

        Season season = new Season();

        season.setId( seasonDTO.getId() );
        season.setCreatedDate( seasonDTO.getCreatedDate() );
        season.setCreatedBy( seasonDTO.getCreatedBy() );
        season.setModifiedDate( seasonDTO.getModifiedDate() );
        season.setModifiedBy( seasonDTO.getModifiedBy() );
        season.setSemester( semesterDTOToSemester( seasonDTO.getSemester() ) );
        season.setSchoolYear( schoolYearDTOToSchoolYear( seasonDTO.getSchoolYear() ) );
        season.setCourses( coursesDTOToCourses( seasonDTO.getCourses() ) );
        season.setDisabled( seasonDTO.isDisabled() );

        return season;
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

    protected List<Subject> subjectDTOListToSubjectList(List<SubjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Subject> list1 = new ArrayList<Subject>( list.size() );
        for ( SubjectDTO subjectDTO : list ) {
            list1.add( subjectDTOToSubject( subjectDTO ) );
        }

        return list1;
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

    protected SemesterDTO semesterToSemesterDTO(Semester semester) {
        if ( semester == null ) {
            return null;
        }

        SemesterDTO semesterDTO = new SemesterDTO();

        semesterDTO.setId( semester.getId() );
        semesterDTO.setCreatedDate( semester.getCreatedDate() );
        semesterDTO.setCreatedBy( semester.getCreatedBy() );
        semesterDTO.setModifiedDate( semester.getModifiedDate() );
        semesterDTO.setModifiedBy( semester.getModifiedBy() );
        semesterDTO.setSemesterName( semester.getSemesterName() );

        return semesterDTO;
    }

    protected SchoolYearDTO schoolYearToSchoolYearDTO(SchoolYear schoolYear) {
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

    protected SeasonDTO seasonToSeasonDTO(Season season) {
        if ( season == null ) {
            return null;
        }

        SeasonDTO seasonDTO = new SeasonDTO();

        seasonDTO.setId( season.getId() );
        seasonDTO.setCreatedDate( season.getCreatedDate() );
        seasonDTO.setCreatedBy( season.getCreatedBy() );
        seasonDTO.setModifiedDate( season.getModifiedDate() );
        seasonDTO.setModifiedBy( season.getModifiedBy() );
        seasonDTO.setSemester( semesterToSemesterDTO( season.getSemester() ) );
        seasonDTO.setSchoolYear( schoolYearToSchoolYearDTO( season.getSchoolYear() ) );
        seasonDTO.setCourses( coursesToCoursesDTO( season.getCourses() ) );
        seasonDTO.setDisabled( season.isDisabled() );

        return seasonDTO;
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

    protected List<SubjectDTO> subjectListToSubjectDTOList(List<Subject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectDTO> list1 = new ArrayList<SubjectDTO>( list.size() );
        for ( Subject subject : list ) {
            list1.add( subjectToSubjectDTO( subject ) );
        }

        return list1;
    }

    protected TuitionDTO tuitionToTuitionDTO(Tuition tuition) {
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

    protected RegisterDTO registerToRegisterDTO(Register register) {
        if ( register == null ) {
            return null;
        }

        RegisterDTO registerDTO = new RegisterDTO();

        registerDTO.setId( register.getId() );
        registerDTO.setCreatedDate( register.getCreatedDate() );
        registerDTO.setCreatedBy( register.getCreatedBy() );
        registerDTO.setModifiedDate( register.getModifiedDate() );
        registerDTO.setModifiedBy( register.getModifiedBy() );
        registerDTO.setSubjectGroup( subjectGroupToSubjectGroupDTO( register.getSubjectGroup() ) );
        registerDTO.setOpenTransaction( register.isOpenTransaction() );
        registerDTO.setGrade( gradeToGradeDTO( register.getGrade() ) );

        return registerDTO;
    }

    protected List<RegisterDTO> registerListToRegisterDTOList(List<Register> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterDTO> list1 = new ArrayList<RegisterDTO>( list.size() );
        for ( Register register : list ) {
            list1.add( registerToRegisterDTO( register ) );
        }

        return list1;
    }

    protected EventRegisterResponse eventRegisterToEventRegisterResponse(EventRegister eventRegister) {
        if ( eventRegister == null ) {
            return null;
        }

        EventRegisterResponse.EventRegisterResponseBuilder eventRegisterResponse = EventRegisterResponse.builder();

        eventRegisterResponse.id( eventRegister.getId() );
        eventRegisterResponse.start( eventRegister.getStart() );
        eventRegisterResponse.end( eventRegister.getEnd() );

        return eventRegisterResponse.build();
    }
}
