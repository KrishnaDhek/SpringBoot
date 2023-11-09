package com.springboot.demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    //expose a endpoint '/'
    @GetMapping("/")
    public String getHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
        public String getDailyWorkout(){
            return "Run 5km!";
        }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }

    //@Value annotation to inject values from properties "coach.name" and "team.name"
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+ coachName + " , TeamName : " +teamName;
    }

}
