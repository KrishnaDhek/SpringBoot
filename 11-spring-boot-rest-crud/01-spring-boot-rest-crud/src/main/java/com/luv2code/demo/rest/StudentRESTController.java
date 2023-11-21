package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        //just index into list
        return theStudent.get(studentId);

    }
}
