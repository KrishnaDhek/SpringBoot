package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * MyApiAnalyticsAspect is an aspect class responsible for performing API analytics.
 * It is annotated with @Aspect to indicate that it is an aspect class.
 * The @Component annotation marks it as a Spring component for auto-discovery.
 * The @Order(3) annotation specifies the order of execution relative to other aspects.
 */
@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {


    /**
     * Advice method executed before methods matching the pointcut defined in AOPDeclarations.
     * It prints a message indicating the start of API analytics.
     */
    @Before("com.springboot.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
