package com.Spring.springcoredemo.common;

import org.springframework.stereotype.Component;
//@Component annotation tells spring that this class should be treated as spring jean, and made
//available for dependency injection
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minute";
    }
}
