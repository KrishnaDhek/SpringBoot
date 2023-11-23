package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    //need a controller method to show the form

    @GetMapping("/showForm")
    public String showform(){
        return "helloword-form";
    }

    //need a controller method to process form

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

}
