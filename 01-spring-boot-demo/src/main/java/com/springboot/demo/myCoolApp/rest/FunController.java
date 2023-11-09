package com.springboot.demo.myCoolApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    //expose a endpoint '/'
    @GetMapping("/")
    public String getHello(){
        return "Hello World!";
    }
}
