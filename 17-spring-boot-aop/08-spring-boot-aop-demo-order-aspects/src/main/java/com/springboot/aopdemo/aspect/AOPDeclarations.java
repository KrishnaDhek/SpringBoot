package com.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * AOPDeclarations class defines pointcuts using AspectJ annotations.
 * It is annotated with @Aspect to indicate that it is an aspect class.
 */
@Aspect
public class AOPDeclarations {

    // Pointcut declaration for methods in the DAO package
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // Pointcut declaration for getter methods in the DAO package
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // Pointcut declaration for setter methods in the DAO package
    @Pointcut("execution(* com.springboot.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // Combined pointcut: include DAO package and exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
