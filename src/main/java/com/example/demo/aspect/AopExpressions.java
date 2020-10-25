package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.example.demo.Service.*.*(..))")
    public void forServicePackage(){}

    //create pointcut: for getter methods
    @Pointcut("execution(* com.example.demo.Service.*.get*(..))")
    public void getter(){}


    //create pointcut: for setter methods
    @Pointcut("execution(* com.example.demo.Service.*.set*(..))")
    public void setter(){}

    //create pointcut: include package ..exclude  getter setter
    @Pointcut("forServicePackage() && !(getter() || setter())")
    public void forServicePackageNoGetterSetter() {}
}
*/