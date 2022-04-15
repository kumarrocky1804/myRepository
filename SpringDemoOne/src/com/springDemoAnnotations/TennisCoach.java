package com.springDemoAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// explicit bean ID
//@Component("sillyCoach")
//default beanID
@Component
public class TennisCoach implements Coach {
	// field DI
	/*@Autowired
	@Qualifier("hardFortune")*/
	private FortuneService fortune;
	// Sprint will access the above field with help of Reflection API
	
	@Value("${foo.team}")
	private String team;
	@Value("${foo.email}")
	private String email;
	
	public String getTeam() {
		return team;
	}

	public String getEmail() {
		return email;
	}

	// constructor DI
	@Autowired
	public TennisCoach(@Qualifier("goodFortune")FortuneService fortune) 
	// will not override the field's qualifier
	{
		this.fortune = fortune;
	}
	
	// setter DI
	/*@Autowired
	@Qualifier("goodFortune") // will override the qualifier in the field
	public void setFortune(FortuneService fortune)
	{
		this.fortune = fortune;
	}*/
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice back-hand 10 times";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortune.getDailyFortune();
	}
	
	@PostConstruct
	public void startup() {
		System.out.println("Init-method of this bean");
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("deatroy method of this bean");
	}

}
