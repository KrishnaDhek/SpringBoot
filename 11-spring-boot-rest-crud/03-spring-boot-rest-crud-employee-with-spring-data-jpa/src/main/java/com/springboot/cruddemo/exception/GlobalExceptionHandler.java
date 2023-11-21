package com.springboot.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Exception handler for EmployeeNotFoundException
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exc){
        // Creating an instance of EmployeeErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        // Setting response status to 404 (Not Found)
        error.setStatus(HttpStatus.NOT_FOUND.value());

        // Setting error message to the message from the exception
        error.setMessage(exc.getMessage());

        // Setting timestamp to the current system time
        error.setTimeStamp(System.currentTimeMillis());

        // Returning the error response with a 404 status
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // Exception handler for EmployeeInvalidException
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeInvalidException(EmployeeInvalidException exc){
        // Creating an instance of EmployeeErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        // Setting response status to 400 (Bad Request)
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        // Setting a generic error message for invalid employee ID
        error.setMessage("Required an integer value for employeeId");

        // Setting timestamp to the current system time
        error.setTimeStamp(System.currentTimeMillis());

        // Returning the error response with a 400 status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Exception handler for MethodArgumentTypeMismatchException
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        // Handle the exception for invalid path variable type

        // Creating a response entity with a 400 (Bad Request) status
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid Employee id format. Required an integer value");
    }


}
