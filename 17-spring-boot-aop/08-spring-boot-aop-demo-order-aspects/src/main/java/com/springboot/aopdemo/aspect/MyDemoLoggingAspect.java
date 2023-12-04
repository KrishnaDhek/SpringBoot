package com.springboot.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyDemoLoggingAspect is an aspect class responsible for logging before methods in the DAO package.
 * It is annotated with @Aspect to indicate that it is an aspect class.
 * The @Component annotation marks it as a Spring component for auto-discovery.
 * The @Order(2) annotation specifies the order of execution relative to other aspects.
 */
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    /**
     * Pointcut declaration for methods in the DAO package excluding getters and setters.
     * It is defined in the AOPDeclarations class.
     */
    @Before("com.springboot.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

}