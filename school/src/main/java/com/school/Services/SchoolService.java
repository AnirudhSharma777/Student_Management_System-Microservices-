package com.school.Services;

import java.util.List;

import com.school.Entities.School;
import com.school.ResponseDto.SchoolResponseDto;

public interface SchoolService {

    public School saveSchool(School school);
    public List<School> findAllSchools();
    public SchoolResponseDto findSchoolsWithStudents(String schoolId);
}
