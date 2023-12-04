package com.springboot.aopdemo.aspect;


import com.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("method :" +methodSignature);


        //display the method arguments
        Object[] args = theJoinPoint.getArgs();

        //get arguments

        for (Object tempArg :args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                //downcast and print Account specific stuff
                  Account theAcc = (Account) tempArg;

                System.out.println("account name :" +theAcc.getName());
                System.out.println("account level :" +theAcc.getLevel());
            }
        }

        //loop through arguments



    }

}