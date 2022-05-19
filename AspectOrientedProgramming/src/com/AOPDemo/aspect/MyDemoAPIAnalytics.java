package com.AOPDemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.AOPDemo.Account;

@Component
//from aspectJ jar
@Aspect
@Order(0)
public class MyDemoAPIAnalytics 
{	
	@Before("com.AOPDemo.aspect.AspectExpressions.forDAOPacakgeExceptGetterAndSetter()")
	public void beforePackageAvoidGetAndSet(JoinPoint joinPoint)
	{
		System.out.println("==========> @BEFORE advice of forDAOPacakgeExceptGetterAndSetter"
				+ " API ANALYTICS");
		
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("The method signature is - ");
		System.out.println(sign);
		
		Object[] args = joinPoint.getArgs();
		System.out.println("Function args are - ");
		for(Object arg: args)
		{
			System.out.println(arg);
			
			// if logs needed for specific objects
			if(arg instanceof Account)
			{
				Account account = (Account) arg;
				System.out.println("Account name- " + account.getName());
				System.out.println("Account level- " + account.getLevel());
			}
		}
	}
	
	
	@AfterReturning(pointcut = "execution(* com.AOPDemo.DAO.AccountDAO.findAccounts(..))",
			returning = "result")
	// name of returning object should be same in the below function
	public void afterReturning(JoinPoint joinPoint, List<Account> result)
	{
		System.out.println("==========> @AFTER Returning advice of findAccounts"
				+ " API ANALYTICS");
		
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("The method signature is - ");
		System.out.println(sign);
		
		System.out.println("==============>Result is - ");
		System.out.println(result);
		
		// we can also modify the data
		Account account = result.get(0);
		account.setName("FAke NAME");
	}
	
	@After("execution(* com.AOPDemo.DAO.AccountDAO.findAccounts(..))")
	// name of returning object should be same in the below function
	public void after(JoinPoint joinPoint)
	{
		// It does not have access to exception if thrown
		System.out.println("==========> @AFTER advice of findAccounts"
				+ " API ANALYTICS");
		
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("The method signature is - ");
		System.out.println(sign);
	}
	
	@AfterThrowing(pointcut = "execution(* com.AOPDemo.DAO.AccountDAO.findAccounts(..))",
			throwing = "exception")
	// name of returning object should be same in the below function
	public void afterThrowing(JoinPoint joinPoint, Throwable exception)
	{
		System.out.println("==========> @AFTER Throwing advice of findAccounts"
				+ " API ANALYTICS");
		
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("The method signature is - ");
		System.out.println(sign);
		
		System.out.println("==============>Exception occured");
		System.out.println(exception);
	}

}
