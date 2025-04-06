package com.springDemoOne;

public class BaseBallCoach implements Coach {
	
	private FortuneService theFortune;
	private String name;
	
	public BaseBallCoach(FortuneService theFortune, String name) {
		super();
		this.theFortune = theFortune;
		this.name = name;
	}

	@Override
	public String getDailyWorkout() 
	{
		return "Practice batting for 1 hr";
	}

	@Override
	public String getFortune() {
		return theFortune.getFortuneMessage();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String extraMethod()
	{
		return "I am in class but not in interface";
	}
	
	public void startup()
	{
		System.out.println("I am init-method for "+ this + " bean");
	}
	
	public void cleanup()
	{
		System.out.println("I am destroy-method for " + this + " bean");
	}

}
