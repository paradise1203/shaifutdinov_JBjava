package com.aidar.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.Date;

public class ServiceAspect {

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Date start = new Date(), end;
        long duration;
        System.out.println("Invoking method "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with arguments "
                + Arrays.toString(joinPoint.getArgs()));
        Object res = joinPoint.proceed();
        end = new Date();
        duration = end.getTime() - start.getTime();
        System.out.println("Started at " + start.toString() + "\n"
                + "Finished at " + end.toString() + "\n"
                + "Duration : " + duration + " ms");
        return res;
    }

    public void processException(JoinPoint joinPoint, Exception exception) {
        System.out.println("Exception: "
                + exception.toString()
                + " catched for arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }

}
