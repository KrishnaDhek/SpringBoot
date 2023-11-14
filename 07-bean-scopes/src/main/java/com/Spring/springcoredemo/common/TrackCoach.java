package com.Spring.springcoredemo.common;


import org.springframework.stereotype.Component;
/**
 * This class represents a Track Coach bean.
 * Marked with the @Component annotation to be detected by Spring component scanning.
 * The @Lazy annotation is used to defer the creation of this bean until it is actually requested.
 * This can improve startup time and resource usage, especially in scenarios where the bean may not be needed immediately.
 */

@Component

public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("In constructor :" +getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
