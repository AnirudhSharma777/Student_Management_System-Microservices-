package com.student.Exception;

public class StudentNotFoundException extends RuntimeException {
    
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException() {
        
    }
}
