package com.AOPDemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.AOPDemo.DAO.AccountDAO;
import com.AOPDemo.DAO.MembershipDAO;
import com.AOPDemo.DAO.service.FortuneService;

public class MainDemoApp {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO member = context.getBean("membershipDAO",MembershipDAO.class);
		FortuneService service = context.getBean("fortuneService", FortuneService.class);
		
		Account account = new Account();
		account.setLevel("Level 1");
		account.setName("New Account");
		accountDAO.addAccount(account);
		
		
		
		System.out.println("\n-------------\n");
		accountDAO.setID(0);
		
		System.out.println("\n-------------\n");
		System.out.println(accountDAO.getID());
		
		System.out.println("\n-------------\n");
		member.addAccount();
		
		System.out.println("\n-------------\n");
		member.goToSleep();
		
		System.out.println("\n-------------\n");
		accountDAO.goToWork(true);
		try {
			List<Account> accounts = accountDAO.findAccounts(false);
			System.out.println("Main Program - - ");
			System.out.println(accounts);
		}
		catch(Exception ex)
		{
			System.out.println("Exception propagated to main program - ");
			System.out.println(ex);
		}
		
		String message = service.getFortune(true);
		System.out.println("\n\n Main Program - fortune - " + message);
		context.close();
	}

}
