package com.student.Exception;

public class AccountCreationFailedException extends RuntimeException{

    public AccountCreationFailedException(String message) {
        super(message);
    }

    public AccountCreationFailedException(){}
}
