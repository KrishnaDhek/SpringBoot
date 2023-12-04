package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //setup logger
     private Logger myLogger = Logger.getLogger(getClass().getName());

     //setup pointcut
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}



    //add @Before

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

    //add @AfterReturning

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        //display method we are returning from
        //display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>>>> in @AfterReturning: calling method: "+method);


        //display the data returned
        myLogger.info("=====>>>>> result: "+theResult);
    }
}
