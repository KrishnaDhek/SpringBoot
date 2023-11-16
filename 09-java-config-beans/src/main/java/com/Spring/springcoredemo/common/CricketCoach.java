package com.Spring.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
//@Component annotation tells spring that this class should be treated as spring jean, and made
//available for dependency injection
@Component
/**
 * CricketCoach class representing a cricket coach bean.
 * Marked with the @Component annotation to be treated as a Spring bean.
 * Demonstrates the use of @PostConstruct and @PreDestroy annotations for custom lifecycle methods.
 */

public class CricketCoach implements Coach{
    /**
     * Default constructor for CricketCoach.
     * Prints a message during the bean's construction.
     */
    public CricketCoach(){
        System.out.println("In constructor :" +getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minute";
    }
}
