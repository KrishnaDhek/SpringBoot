package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

    @Before("com.springboot.aopdemo.aspect.AOPDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=====>>> Logging to the Cloud in async fashion");
    }
}
