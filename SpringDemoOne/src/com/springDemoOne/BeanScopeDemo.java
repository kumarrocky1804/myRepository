package com.springDemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScopeContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		// If BaseBallCoach is passed as class type, the we can use extraMethod() which is
		// not in coach interface
		/*BaseBallCoach myCoach = context.getBean("myCoach", BaseBallCoach.class);
		System.out.println(myCoach.extraMethod());*/
		
		Coach myCoach2 =  context.getBean("myCoach", Coach.class);
		
		boolean result = (myCoach==myCoach2);
		
		// try the below code with scope=singelton(default) and prototype in XML
		System.out.println("Are both objects equal? - " + result);
		System.out.println("Coach location - " + myCoach);
		System.out.println("Coach2 location - " + myCoach2);
		
		context.close();
		
		/*
		 * Note - For prototype scope, the destroy method is not called as the container
		 * does not handle the complete life cycle of prototype bean. It only intantiate it,
		 * and handover to client.
		 */
	}

}
