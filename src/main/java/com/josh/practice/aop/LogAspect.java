package com.josh.practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 實作AOP
 */
@Component
// 加上@Aspect標記讓Spring將這個類別視為切面(Aspect)
@Aspect
public class LogAspect {
    // 套用到com.josh.practice.aop.manager這個套件及子套件下所有元件類別的public方法
    @Pointcut("execution(* com.josh.practice.aop.controller..*(..))")
    public void pointcut() {
    }

    // 利用Java Reflection得到Method物件，再取出方法名稱
    private String getMethodName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getName();
    }

    /*@Before("pointcut()")
    // JoinPoint：獲取執行方法的資訊
    public void before(JoinPoint joinPoint) {
        System.out.println("=====before advice starts=====");
        System.out.println("method: " + getMethodName(joinPoint));
        // 方法所接收的參數
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println("=====before advice ends=====");
    }*/

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("=====around advice starts=====");
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("proceed: " + proceed);
        long spentTime = System.currentTimeMillis() - startTime;
        System.out.println("Time spent: " + spentTime);
        System.out.println("=====around advice ends=====");
        return proceed;
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("=====after throwing advice starts=====");
        System.out.println(getMethodName(joinPoint));
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println("throwable message: " + throwable.getMessage());
        System.out.println("=====after throwing advice ends=====");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("-----after returning advice starts=====");
        if (result != null) {
            System.out.println(result);
        }
        System.out.println("=====after returning advice ends=====");
    }
}
