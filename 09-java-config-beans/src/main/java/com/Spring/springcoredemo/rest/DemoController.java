package com.Spring.springcoredemo.rest;

import com.Spring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
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
    public  DemoController(@Qualifier("ocean") Coach theCoach){
        // Use @Qualifier to specify the desired bean when multiple implementations of Coach are present
        // In this case, "cricketCoach" is the bean name

        System.out.println("In constructor :"+getClass().getSimpleName());
        mycoach = theCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }

    //to check the scope of the bean, if the scope is singleton then it will return true else false
    //singleton scope is the scope where both the bean myCoach and anotherCoach point to the same in stance

}
