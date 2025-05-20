package com.student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.student.ResponseDto.ErrorResponse;

@RestControllerAdvice
public class GlobalHandlerException {

    
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(StudentNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse("USER_NOT_FOUND", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountCreationFailedException.class)
    public ResponseEntity<Object> handleSignUpFailedException(AccountCreationFailedException ex) {
        return new ResponseEntity<>(new ErrorResponse("SIGNUP_FAILED", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

     // Fallback for unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("INTERNAL_SERVER_ERROR", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
