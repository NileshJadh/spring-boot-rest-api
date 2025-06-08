package com.rocky.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type class_name.method_name(args)

    @Before("execution(* com.rocky.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.rocky.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method called");
    }

    @After("execution(* com.rocky.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.rocky.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCallExecuted(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method execute");
    }
    @AfterThrowing("execution(* com.rocky.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.rocky.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method has some issue or exception");
    }
    @AfterReturning("execution(* com.rocky.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.rocky.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info(jp.getSignature().getName() + " Method executed successfully");
    }
}
