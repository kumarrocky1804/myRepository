package com.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectExpressions {
	@Pointcut("execution(* com.AOPDemo.DAO.*.*(..))")
	public void forDAOPackage() {}

	@Pointcut("execution(* com.AOPDemo.DAO.*.get*(..))")
	public void getters() {}

	@Pointcut("execution(* com.AOPDemo.DAO.*.set*(..))")
	public void setters() {}

	@Pointcut("forDAOPackage() && !(getters() || setters())")
	public void forDAOPacakgeExceptGetterAndSetter() {}
}
