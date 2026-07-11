package Basic;

import java.util.Scanner;

class InsufficientBalanceException extends Exception
{
	public InsufficientBalanceException(String msg)
	{
		super(msg);
	}
}

class Bank
{
	int balance = 1000;
	
	public void withdraw(int amount)throws InsufficientBalanceException
	{
		if(amount <= 1000)
			System.out.println(amount + " withdrawn successfully");
		else
			throw new InsufficientBalanceException("you can only withdraw 1000");
	}
}

public class ExceptionHandling 
{
	public static void main(String[] args)
	{
		try {
			Bank b = new Bank();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the amount to withdraw - ");
			int amount = sc.nextInt();
			
			b.withdraw(amount);
		}
		catch(Exception ex)
		{
			System.out.println("In catch block - ");
			ex.printStackTrace();
		}
		/*catch(ArithmeticException ex)
		{
			won't compile as this is unreachable code.
		}*/
		finally
		{
			System.out.println("Finally block executed");
		}
	}
}
