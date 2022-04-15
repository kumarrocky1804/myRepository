package com.springDemoOne;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String team;
	private String email;
	
	public String getTeam() {
		return team;
	}

	public String getEmail() {
		return email;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CricketCoach()
	{
		System.out.println("Default constructor called");
	}
	
	public void setFortuneService(FortuneService fortuneService)
	{
		System.out.println("Setter function called");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice bowling";
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortuneMessage();
	}

}
