package com.example.sideproject.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Profile("dev")
public class DevAspect {
    @Pointcut("within(com.example.sideproject.controller.*)")
    public void executionTime(){
    }

    @Around("executionTime()")
    public Object logAllFunction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        String messageFormatted = String.format("Time run function %s at %s is %s ms", methodName, className,executionTime);
        System.out.println(messageFormatted);

        return proceed;
    }
}
