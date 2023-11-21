package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRESTController {

    // List to store student data
    private List<Student> theStudent;


    // @PostConstruct annotation to load student data only once

    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("Prashant","Patel"));
        theStudent.add(new Student("John","Woo")) ;
        theStudent.add(new Student("Tom","Zad")) ;


    }

    //defining endpoint for "/student"

    @GetMapping("/students")
    public List<Student> getStudent(){
        //create sample student
        return theStudent;
    }

    //define endpoints for "/student/{studentId}"- return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Check if the studentId is within valid bounds
        if((studentId >= theStudent.size() ) || ( studentId<0 )){

            // Throw a custom exception if the student is not found
            throw new StudentNotFoundException("Student id not found :"+studentId);

        }

        // Return the specific student based on the provided ID
        return theStudent.get(studentId);

    }

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
}
