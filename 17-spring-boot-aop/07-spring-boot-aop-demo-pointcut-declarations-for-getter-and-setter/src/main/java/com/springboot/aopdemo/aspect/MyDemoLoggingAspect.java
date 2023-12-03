package com.springboot.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(* com.springboot.aopdemo.dao.*.*(..))")
    private void forDAOPackage(){ }

    //create pointcut for getter method
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.get*(..))")
    private void getter(){ }


    //create pointcut for setter method
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.set*(..))")
    private void setter(){ }

    //create pointcut: include package.. exclude getter/setter
    @Pointcut("forDAOPackage() && !getter() !setter()")
    private void forDAOPackageNoGetterSetter(){ }


    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccount(){
        System.out.println("\n======>>> Executing @Before advice on method");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n========>>>> Performing API Analytics");
    }
}

