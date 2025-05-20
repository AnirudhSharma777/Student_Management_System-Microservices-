package com.school.ResponseDto;

import java.util.List;

import com.school.Client.Student;

public record SchoolResponseDto(
        String id,
        String name,
        String email,
        List<Student> students) {

}
