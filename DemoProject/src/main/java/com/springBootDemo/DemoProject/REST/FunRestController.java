package com.springBootDemo.DemoProject.REST;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController 
{
	// injecting properties values from props file
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamname;
	
	@GetMapping("/")
	public String returnDate()
	{
		return "Hello world at - " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String returnWork()
	{
		return "Ran 5k ";
	}
	
	@GetMapping("/teamInfo")
	public String getTeamInfo()
	{
		return "Coach - " + coachName + " Team - " + teamname;
	}
}
