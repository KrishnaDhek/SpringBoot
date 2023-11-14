package com.Spring.springcoredemo.rest;

import com.Spring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach mycoach;
//
//    //defined a constructor for dependency injection
//    @Autowired//tells spring for dependency injection
//    // if only one constructor then @Autowired is optional
//    public DemoController(Coach theCoach){
//        mycoach = theCoach;
//    }

    @Autowired
    public  DemoController(Coach theCoach){
        // Use @Qualifier to specify the desired bean when multiple implementations of Coach are present
        // In this case, "cricketCoach" is the bean name


        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }

}
