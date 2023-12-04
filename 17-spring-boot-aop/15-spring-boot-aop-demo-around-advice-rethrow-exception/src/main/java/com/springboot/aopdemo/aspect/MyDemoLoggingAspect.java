package com.springboot.aopdemo.aspect;


import com.springboot.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Around("execution(* com.springboot.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint)throws  Throwable{

        //print out method we are advising on
        //print on which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>>>> Executing the @Around  on method :"+method);

        //get begin timeStamp
        long begin =System.currentTimeMillis();

        //execute the method
        Object result =null;

        try {
          result = theProceedingJoinPoint.proceed();

        }catch (Exception exc){
            //log the exception
            System.out.println(exc.getMessage());

           //rethrow exception

            throw exc;

        }

        //get end timeStamp
        long end =System.currentTimeMillis();

        //compute duration and display timeStamp

        long duration = end-begin;
        System.out.println("\n====>>> Duration: " +duration/1000.0+ "seconds");

        return result;
    }

    @After("execution(* com.springboot.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint){

        //print on which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n======>>>>> Executing the @After (finally) on method :"+method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice( JoinPoint theJointPoint , Throwable theExc){

        //print on which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n======>>>>> Executing the @AfterThrowing on method :"+method);

        //log the exception
        System.out.println("\n========>>> The exception is :" +theExc);


    }
    @AfterReturning(
            pointcut = "execution(* com.springboot.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterRunningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing the @AfterRunning on method: " +method);

        //print put the results of the method call
        System.out.println("\n=====>>> result is: "+result);

        //post-process the data



        //convert the account name to uppercase
        convertAccountNameToUpperCase(result);
        System.out.println("\n=====>>> result is: "+result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        //loop through account
        for (Account tempAcc : result) {

            //get uppercase version
            String theUpperName = tempAcc.getName().toUpperCase();

            //update the name
            tempAcc.setName(theUpperName);
        }
    }

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

        //get arguments
        Object[] args = theJoinPoint.getArgs();

        //loop through arguments
        for (Object tempArg :args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                //downcast and print Account specific stuff
                  Account theAcc = (Account) tempArg;

                System.out.println("account name :" +theAcc.getName());
                System.out.println("account level :" +theAcc.getLevel());
            }
        }





    }

}