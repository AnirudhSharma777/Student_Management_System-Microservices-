package com.student.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Dto.StudentRequest;
import com.student.Entities.Student;
import com.student.ResponseDto.StudentResponseDto;
import com.student.Services.StudentServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

   private final StudentServiceImpl studentService;

   @PostMapping("/students")
   public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentRequest request)
         throws Exception {
      return ResponseEntity.ok(studentService.saveStudent(request));
   }

   @GetMapping("/students")
   public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
      return ResponseEntity.ok(studentService.findAllStudents());
   }

   @DeleteMapping("/students/{id}")
   public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) throws Exception {
      studentService.deleteStudent(id);
      return ResponseEntity.noContent().build();
   }

   @GetMapping("/students/{id}")
   public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable("id") String id) {
      return ResponseEntity.ok(studentService.findStudentById(id));
   }

   @PutMapping("/students/{id}")
   public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable("id") String id,
         @Valid @RequestBody StudentRequest request) throws Exception {
      return ResponseEntity.ok(studentService.updateStudent(id, request));
   }

   @GetMapping("/students/school/{school-id}")
   public ResponseEntity<List<Student>> findAllStudents(
         @PathVariable("school-id") String schoolId) {
      return ResponseEntity.ok(studentService.findAllBySchoolId(schoolId));
   }

}
