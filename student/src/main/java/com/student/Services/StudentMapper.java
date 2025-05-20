package com.student.Services;

import org.springframework.stereotype.Component;

import com.student.Dto.StudentRequest;
import com.student.Entities.Student;
import com.student.ResponseDto.StudentResponseDto;

@Component
public class StudentMapper {

    public Student mapToStudent(StudentRequest request) {

        if(request == null){
            return null;
        }

        Student student = Student.builder()
        .firstname(request.firstname())
        .lastname(request.lastname())
        .email(request.email())
        .schoolId(request.schoolId())
        .build();

        return student;

    }


   public StudentResponseDto mapToStudentResponseDto(Student student) {
    if (student == null) {
        return null;
    }

    return new StudentResponseDto(
        student.getStudentId(),
        student.getFirstname(),
        student.getLastname(),
        student.getEmail(),
        student.getSchoolId()
    );
}


}
