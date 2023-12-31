package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //need a controller method to show the form

    @GetMapping("/showForm")
    public String showform(){
        return "helloword-form";
    }

    //need a controller method to process form

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller method to read form data
    @RequestMapping("/processFormVersionTwo")
    public String readData(HttpServletRequest request, Model model){

        //read request parameter from html form
        String name = request.getParameter("studentName");

        //convert data to UpperCase
        name = name.toUpperCase();

        //create the message
        String result = "Yo! " +name;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){


        //convert data to UpperCase
        name = name.toUpperCase();

        //create the message
        String result = "Hey! " +name;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
