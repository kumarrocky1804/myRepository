package com.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
// from aspectJ jar
@Aspect
@Order(-20)
public class MyDemoLoginAspect 
{
	// we can add all our advices here
	// pointcut expression saying that execute this before any function named addAccount
	/*@Before("execution(public void addAccount())")
	public void beforeAdvice()
	{
		System.out.println("==========> @BEFORE advice Execution on addAccount()");
	}*/

	// only accountDAO advice - 
	/*@Before("execution(public void com.AOPDemo.DAO.AccountDAO.addAccount())")
	public void beforeAccountDAO()
	{
		System.out.println("==========> @BEFORE advice Execution on AccountDAO's addAccount()");
	}*/

	/*@Before("execution(* add*(com.AOPDemo.Account))")
	public void beforeAddMethod()
	{
		System.out.println("==========> @BEFORE advice of * add*(com.AOPDemo.Account)");
	}*/

	//any method in any class in this package with any number of params
	/*@Before("forDAOPackage()")
	public void beforePackage()
	{
		System.out.println("==========> @BEFORE advice of * com.AOPDemo.DAO.*.*(..)");
	}*/

	//any method in any class in this package with any number of params
	@Before("com.AOPDemo.aspect.AspectExpressions.forDAOPacakgeExceptGetterAndSetter()")
	public void beforePackageAvoidGetAndSet()
	{
		System.out.println("==========> @BEFORE advice of forDAOPacakgeExceptGetterAndSetter");
	}	
}
