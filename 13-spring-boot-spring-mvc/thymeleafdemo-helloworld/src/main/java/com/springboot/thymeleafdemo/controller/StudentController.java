package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // Adding countries, gender, language, and operatingSystem as values from application.properties
    @Value("${countries}")
    private List<String>countries;

    @Value("${gender}")
    private List<String>gender;

    @Value("${language}")
    private List<String>language;

    @Value("${operatingSystem}")
    private List<String> operatingSystem;

    // Method to show the student form
    @GetMapping("/showStudentForm")
    public String showForm(Model themodel){

        //create Student object
        Student theStudent = new Student();

        // Add the student object and other lists to the model
        themodel.addAttribute("student", theStudent);
        themodel.addAttribute("countries", countries);
        themodel.addAttribute("gender", gender);
        themodel.addAttribute("language", language);
        themodel.addAttribute("operatingSystem", operatingSystem);

        // Return the view name for rendering the student form
        return "student-form";
    }


    // Method to process the student form submission

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")Student theStudent){

        //log the input data
        System.out.println("theStudent :" +theStudent.getFirstName()+" "+theStudent.getLastName());

        // Return the view name for rendering the confirmation page
        return "student-confirmation";
    }
}














