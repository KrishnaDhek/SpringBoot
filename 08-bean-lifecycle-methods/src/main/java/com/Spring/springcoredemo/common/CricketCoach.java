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

    //define our init method
    /**
     * Custom initialization method marked with @PostConstruct.
     * This method will be invoked after the bean has been constructed.
     * Prints a message during the startup phase.
     */
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff :"+getClass().getSimpleName());
    }

    //define our destroy method
    /**
     * Custom cleanup method marked with @PreDestroy.
     * This method will be invoked before the bean gets destroyed.
     * Prints a message during the cleanup phase.
     */
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff :"+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minute";
    }
}
