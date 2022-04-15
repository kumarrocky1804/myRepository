package com.springDemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDepedencyInjectionDemo 
{
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CricketCoach myCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(myCricketCoach.getDailyWorkout());
		System.out.println(myCricketCoach.getFortune());
		
		System.out.println(myCricketCoach.getEmail());
		System.out.println(myCricketCoach.getTeam());
		
		context.close();
	}
}
