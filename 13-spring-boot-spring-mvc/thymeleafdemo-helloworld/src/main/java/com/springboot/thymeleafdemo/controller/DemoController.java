package com.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create a mapping for '/hello'
    @GetMapping("/hello")
    public String sayHello(Model theMode){

       theMode.addAttribute("theDate", new java.util.Date());

        // return the name of the Thymeleaf template (without file extension)
        return "helloworld";
    }


}
