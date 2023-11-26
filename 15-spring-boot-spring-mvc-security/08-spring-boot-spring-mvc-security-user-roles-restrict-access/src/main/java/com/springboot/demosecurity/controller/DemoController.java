package com.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    //add mapping for "/leaders"

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    //add mapping for "/leaders"

    @GetMapping("/systems")
    public String showAdmins(){
        return "systems";
    }

}
