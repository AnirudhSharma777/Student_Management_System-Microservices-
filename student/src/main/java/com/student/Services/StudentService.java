package com.student.Services;

import java.util.List;

import com.student.Dto.StudentRequest;
import com.student.Entities.Student;
import com.student.ResponseDto.StudentResponseDto;

public interface StudentService {

    public StudentResponseDto saveStudent(StudentRequest request) throws Exception;
    public List<StudentResponseDto> findAllStudents();
    public StudentResponseDto findStudentById(String id);
    public StudentResponseDto updateStudent(String id, StudentRequest request) throws Exception;
    public void deleteStudent(String id) throws Exception;
    public List<Student> findAllBySchoolId(String schoolId);
}
