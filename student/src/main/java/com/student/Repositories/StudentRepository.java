package com.student.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{
    Optional<Student> findByEmail(String email);
    List<Student> findAllBySchoolId(String schoolId);
}
