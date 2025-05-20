package com.student.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.Dto.StudentRequest;
import com.student.Entities.Student;
import com.student.Exception.StudentAlreadyExists;
import com.student.Exception.StudentNotFoundException;
import com.student.Repositories.StudentRepository;
import com.student.ResponseDto.StudentResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto saveStudent(StudentRequest request) throws Exception {

        var student = studentRepository.findByEmail(request.email());
        if (student.isPresent()) {
            throw new StudentAlreadyExists("Student is already exists");
        }

        Student s = studentMapper.mapToStudent(request);
        studentRepository.save(s);

        return studentMapper.mapToStudentResponseDto(s);

    }

    @Override
    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::mapToStudentResponseDto).toList();
    }

    @Override
    public StudentResponseDto findStudentById(String id) {
        return studentRepository.findById(id).map(studentMapper::mapToStudentResponseDto)
                .orElseThrow();
    }

    @Override
    public StudentResponseDto updateStudent(String id, StudentRequest request) throws Exception {

        var student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        studentMapper.mapToStudent(request);

        studentRepository.save(student);

        return studentMapper.mapToStudentResponseDto(student);

    }

    @Override
    public void deleteStudent(String id) throws Exception {

        Student student = studentRepository.findById(id).orElseThrow();

        if (student == null) {
            throw new StudentNotFoundException(
                    String.format("", id));
        }

        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> findAllBySchoolId(String schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
