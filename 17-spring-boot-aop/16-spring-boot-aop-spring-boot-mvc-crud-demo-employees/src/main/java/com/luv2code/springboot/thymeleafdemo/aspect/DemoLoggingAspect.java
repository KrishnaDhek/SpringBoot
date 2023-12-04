package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * DemoLoggingAspect is an Aspect class for logging method calls in specific packages.
 * It utilizes Spring AOP to intercept and log method executions.
 */
@Aspect
@Component
public class DemoLoggingAspect {

    // Logger to record log messages
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // Pointcuts for specific packages
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}


    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    // Combined pointcut for the entire application flow
    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}




    /**
     * Advice method executed before the method in the specified packages.
     *
     * @param theJoinPoint JoinPoint containing information about the method call
     */

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        //display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>>>> in @Before: calling method: "+method);

        //display the argument to the method

        //get the arguments
        Object[] args = theJoinPoint.getArgs();

        //loop threw and display args
        for (Object theArg: args) {
            myLogger.info("====>>>>> argument: "+theArg);
        }


    }

    /**
     * Advice method executed after a method in the specified packages returns a value.
     *
     * @param theJoinPoint JoinPoint containing information about the method call
     * @param theResult    Object representing the result returned by the method
     */

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // Display the method being returned from
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>>>> in @AfterReturning: calling method: "+method);


        // Display the data returned by the method
        myLogger.info("=====>>>>> result: "+theResult);
    }
}
