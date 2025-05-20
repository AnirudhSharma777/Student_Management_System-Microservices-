package com.student.Exception;

public class StudentAlreadyExists extends RuntimeException {

    public StudentAlreadyExists(String message) {
        super(message);
    }

    public StudentAlreadyExists() {
        
    }
}
