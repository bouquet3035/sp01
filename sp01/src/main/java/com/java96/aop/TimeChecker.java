package com.java96.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Aspect
@Log

public class TimeChecker {
	
	
	
	//@Before("execution(* com.java96.service.*.*(..))")
	public void sample1(JoinPoint jp) {
		log.info("------------------------------");
		log.info(""+Arrays.toString(jp.getArgs()) );
		log.info("------------------------------");
	}
	
	@Around("execution(* com.java96.service.*.*(..))")
	public Object sampleAround(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis() ; 
		
		String methodName = jp.getSignature().getName();
		
		//Method.invoke() 
		Object result = jp.proceed(); 
		
		long end = System.currentTimeMillis();
		
		log.info(methodName+" "+(end-start));
		
		return result; 
	}
	
	
	
	
}
