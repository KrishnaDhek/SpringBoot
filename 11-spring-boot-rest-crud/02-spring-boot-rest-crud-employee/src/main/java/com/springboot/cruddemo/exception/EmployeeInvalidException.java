package com.springboot.cruddemo.exception;

public class EmployeeInvalidException extends RuntimeException{
    public EmployeeInvalidException(String message, Throwable cause){
        super(message, cause);
    }
}
