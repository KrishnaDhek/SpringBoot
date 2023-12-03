package com.springboot.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// An Aspect class to encapsulate cross-cutting concerns like logging
@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is here we add all of our related advices for logging



    // Pointcut expression for @Before advice
    // Match any method in classes within the com.springboot.aopdemo.dao package and its subpackages
    // The '*' before 'com' indicates any return type
    // The '..' after 'dao' indicates any number of subpackages
    // The '*' before '*' indicates any method name
    // The '(..)' indicates any number of parameters
    @Before("execution(* com.springboot.aopdemo.dao..*(..))")
    public void beforeAddAccount(){
        System.out.println("\n======>>> Executing @Before advice on method");
    }
}

