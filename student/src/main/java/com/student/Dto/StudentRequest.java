package com.student.Dto;


public record StudentRequest(
    String firstname,
    String lastname,
    String email,
    String schoolId
) {

}
