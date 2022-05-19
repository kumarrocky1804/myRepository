package com.AOPDemo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.AOPDemo.Account;

@Component
public class AccountDAO 
{
	private int ID;
	
	
	public int getID() {
		System.out.println(getClass() + " GETID method");
		return ID;
	}

	public void setID(int iD) {
		System.out.println(getClass() + " SETID method");
		ID = iD;
	}

	public void addAccount(Account account)
	{
		System.out.println(getClass() + " DOING MY DB WORK: ADDING ACCOUNT");
	}
	
	public void goToWork(boolean var)
	{
		System.out.println(getClass() + " will got to work - " + var);
	}
	
	public List<Account> findAccounts(boolean trip)
	{
		ArrayList<Account> list = new ArrayList<Account>();
		
		list.add(new Account("Name","level"));
		list.add(new Account("VIP", "GOLD"));
		list.add(new Account("PM", "Platinum"));
		
		if(trip)
		{
			throw new RuntimeException("NO ACCOUNTS FOR YOU");
		}
		
		return list;
	}
}
