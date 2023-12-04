package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyCloudAsyncAspect is an aspect class responsible for logging to the Cloud in an async fashion.
 * It is annotated with @Aspect to indicate that it is an aspect class.
 * The @Component annotation marks it as a Spring component for auto-discovery.
 * The @Order(1) annotation specifies the order of execution relative to other aspects.
 */
@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

    /**
     * Advice method executed before methods matching the pointcut defined in AOPDeclarations.
     * It prints a message indicating logging to the Cloud in an async fashion.
     */

    @Before("com.springboot.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=====>>> Logging to the Cloud in async fashion");
    }
}
