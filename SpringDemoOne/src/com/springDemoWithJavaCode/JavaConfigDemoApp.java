package com.springDemoWithJavaCode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// explicit bean ID
		//Coach coach = context.getBean("sillyCoach", Coach.class);
		// default bean ID
		Coach coach = context.getBean("swimCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		/*TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());*/
		
		context.close();
	}

}
