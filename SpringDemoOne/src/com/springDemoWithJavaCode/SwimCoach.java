package com.springDemoWithJavaCode;

public class SwimCoach implements Coach {
	
	private FortuneService fortune;
	
	public SwimCoach(FortuneService fortune)
	{
		this.fortune = fortune;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "DO 100m laps";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortune.getDailyFortune();
	}

}
