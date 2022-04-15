package com.springDemoAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("Annotation-Context.xml");
		
		// explicit bean ID
		//Coach coach = context.getBean("sillyCoach", Coach.class);
		// default bean ID
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		/*TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());*/
		
		context.close();
		
		/*
		 * As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no 
		 * longer necessary if the target bean only defines one constructor to begin with. 
		 * However, if several constructors are available, at least one must be annotated to 
		 * teach the container which one to use.
		 */
	}

}
