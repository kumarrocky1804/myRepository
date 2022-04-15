package com.springDemoOne;

public class RunningCoach implements Coach {
	
	private FortuneService theFortune;
	
	public RunningCoach(FortuneService theFortune) {
		super();
		this.theFortune = theFortune;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run like Wind";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return theFortune.getFortuneMessage();
	}
}
