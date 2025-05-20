package com.school.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.Client.StudentClient;
import com.school.Entities.School;
import com.school.Exception.SchoolAlreadyExists;
import com.school.Repositories.SchoolRepository;
import com.school.ResponseDto.SchoolResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    @Override
    public School saveSchool(School school) {
       var exist =  repository.findByName(school.getName());
       if (exist != null) {
        throw new SchoolAlreadyExists("School is Already Exists");
       } 

       School newSchool = repository.save(school);
       
       return newSchool;
       
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public SchoolResponseDto findSchoolsWithStudents(String schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build());
        var students = client.findAllStudentsBySchool(schoolId);
        return new SchoolResponseDto(
                school.getId(),
                school.getName(),
                school.getEmail(),
                students);
    }

    

}
