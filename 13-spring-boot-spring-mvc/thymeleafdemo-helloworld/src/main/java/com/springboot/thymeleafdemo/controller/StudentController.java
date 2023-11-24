package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    //method to show form
    @GetMapping("/showStudentForm")
    public String showForm(Model themodel){

        //create Student object
        Student theStudent = new Student();

        //add student object to model
        themodel.addAttribute("student", theStudent);
        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")Student theStudent){

        //log the input data
        System.out.println("theStudent :" +theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }
}














