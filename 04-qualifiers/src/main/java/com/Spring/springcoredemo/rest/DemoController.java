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
    public  DemoController(@Qualifier("cricketCoach") Coach theCoach){

        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkout();
    }

}
