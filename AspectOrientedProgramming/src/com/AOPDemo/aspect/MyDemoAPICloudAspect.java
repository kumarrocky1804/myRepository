package com.AOPDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//from aspectJ jar
@Aspect
@Order(3)
public class MyDemoAPICloudAspect 
{	
	@Before("com.AOPDemo.aspect.AspectExpressions.forDAOPacakgeExceptGetterAndSetter()")
	public void beforePackageAvoidGetAndSet()
	{
		System.out.println("==========> @BEFORE advice of forDAOPacakgeExceptGetterAndSetter"
				+ " CLOUD ANALYTICS");
	}

	@Around("execution(* com.AOPDemo.DAO.service.*.getFortune(..))")
	public Object AroundAdvice(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("=========> In Around Advice");
		// begin time stamp
		long begin = System.currentTimeMillis();

		Object result = null;
		// run function
		try {
			result = jp.proceed();
		}
		catch(Exception ex)
		{
			// we can rethrow it or handle it -
			//throw ex;
			
			System.out.println("===> exception occured in advice @Around- " + ex);
			result = "I SWALLOwed the exception";
		}
		// end time stamp
		long end = System.currentTimeMillis();

		long duration = end-begin;

		System.out.println("==========> Duration to call this is - " + duration);

		return result;
	}
}
