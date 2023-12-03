package com.springboot.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// An Aspect class to encapsulate cross-cutting concerns like logging
@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is here we add all of our related advices for logging

    //start with @Before advice
    //pointcut expression
    //Run this BEFORE - the target object method  addAccount()
//    @Before("execution(public void add*())")
    @Before("execution(* add*(com.springboot.aopdemo.Account))")
    public void beforeAddAccount(){
        System.out.println("\n======>>> Executing @Before advice on method");
    }
}

