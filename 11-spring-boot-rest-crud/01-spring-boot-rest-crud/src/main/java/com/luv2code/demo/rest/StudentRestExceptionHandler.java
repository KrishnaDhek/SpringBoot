package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//This annotation is used to define global exception handling for your application.
//It allows you to consolidate your exception handling logic into a single class that is applied to all controllers.
@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code here
    // Exception handler for handling StudentNotFoundException
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // Create a custom error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity with the custom error response and 404 status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // Additional exception handler for handling non-integer path variable
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Required an integer value for studentId");
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity with the custom error response and 400 status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
