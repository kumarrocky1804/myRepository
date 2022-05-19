package com.AOPDemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO 
{
	public void addAccount()
	{
		System.out.println(getClass() + " DOING MY DB WORK: ADDING MemberSHip");
	}
	
	public void goToSleep()
	{
		System.out.println(getClass() + " GOing to sleep");
	}
}
