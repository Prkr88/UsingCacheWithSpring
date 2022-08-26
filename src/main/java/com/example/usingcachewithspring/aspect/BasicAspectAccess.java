package com.example.usingcachewithspring.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BasicAspectAccess {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("com.example.usingcachewithspring.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object o  = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}ms", joinPoint, timeTaken);
		return o;
	}
}

