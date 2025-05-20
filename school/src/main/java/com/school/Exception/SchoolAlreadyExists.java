package com.school.Exception;

public class SchoolAlreadyExists extends RuntimeException{

    public SchoolAlreadyExists(String msg) {
        super(msg);
    }

    public SchoolAlreadyExists(){}
}
