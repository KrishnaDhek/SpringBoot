package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentRESTController {

    //defining endpoint for "/student"

    @GetMapping("/students")
    public List<Student> getStudent(){
        //create sample student

        List<Student> theStudent = new ArrayList<>();

        theStudent.add(new Student("Prashant","Patel"));
        theStudent.add(new Student("John","Woo")) ;
        theStudent.add(new Student("Tom","Zad")) ;
        return theStudent;
    }

}
