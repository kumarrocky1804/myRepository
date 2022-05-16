package com.springAppDemo.Aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect 
{
	// setup logger
	private Logger mylogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.springAppDemo.Controllers.*.*(..))")
	private void forController() {}
	
	@Pointcut("execution(* com.springAppDemo.services.*.*(..))")
	private void forService() {}
	
	@Pointcut("execution(* com.springAppDemo.DAO.*.*(..))")
	private void forDAO() {}
	
	@Pointcut("forController() || forService() || forDAO()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint jp)
	{
		String method = jp.getSignature().toShortString();
		mylogger.info("=========> In Before : Method called :- " + method);
		
		Object[] args = jp.getArgs();
		
		for(Object arg: args)
		{
			mylogger.info("===> argument - " + arg);
		}
	}

	@AfterReturning(pointcut = "forAppFlow()",returning = "result")
	public void before(JoinPoint jp, Object result)
	{
		String method = jp.getSignature().toShortString();
		mylogger.info("=========> In Returning : Method called :- " + method);
		
		mylogger.info("=========> In Returning : Result :- " + result);
	}
}
