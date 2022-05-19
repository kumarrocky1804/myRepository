package com.AOPDemo.DAO.service;

import org.springframework.stereotype.Component;

@Component
public class FortuneService 
{
	public String getFortune(boolean trip)
	{
		if(trip)
		{
			throw new RuntimeException("NO MORE SOUP LEFT");
		}
		return "Have a Good day";
	}
}
