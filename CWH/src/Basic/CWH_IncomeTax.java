package Basic;

import java.util.Scanner;

public class CWH_IncomeTax {
	
	public static void main(String[] args) {
		float income;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your taxable income");
		income = sc.nextFloat();
		
		System.out.println("Your tax is .");
		if(income <= 250000)
		{
			System.out.println("0");
		}
		else if (income > 250000 && income <= 500000)
		{
			System.out.println(0.05 * income);
		}
		else if (income > 500000 && income <= 1000000)
		{
			System.out.println((0.05 * 250000) + (0.2 * (income-500000)));
		}
		else
		{
			System.out.println((0.05 * 250000) + (0.2 * 500000) + (0.3 * (income - 1000000)));
		}
		
		sc.close();
	}

}
