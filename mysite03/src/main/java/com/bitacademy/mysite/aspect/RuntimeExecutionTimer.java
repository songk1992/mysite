package com.bitacademy.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*
 * 
 * 서비스도 아니고 repo 도 아니기 때문에 component
 */

@Aspect
@Component
public class RuntimeExecutionTimer {
	
	@Around("execution(* *..*.repository.*..*(..)) || execution(* *..*.service.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		// before advice
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		// after advice
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		
		System.out.println("[Execution Time][" + taskName + "]" + totalTime + "millis");
		
		return result;
	}
}
