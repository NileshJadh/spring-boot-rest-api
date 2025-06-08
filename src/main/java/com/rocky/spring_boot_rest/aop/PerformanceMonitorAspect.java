package com.rocky.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.rocky.spring_boot_rest.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed with the method execution
        Object obj = pjp.proceed();

        long end = System.currentTimeMillis();

        // Log the time taken

        LOGGER.info("Start Time: {}", start);
        LOGGER.info("End Time: {}", end);
        LOGGER.info("Time Taken: {} ms", (end - start));



        return obj;
    }
}
