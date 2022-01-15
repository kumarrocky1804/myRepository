package Basic;

import java.util.Random;
import java.util.Scanner;

public class CWH_RockPaperScissor {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random num = new Random();
		
		int userInput,cpuInput;
		String playAgain = "y";
		// 0 for Rock
		// 1 for Paper
		// 2 for scissor
		while(playAgain.equalsIgnoreCase("y"))
		{
			System.out.println("Enter your Move");
			System.out.println(" 0: Rock, 1: Paper, 2: Scissor");
			userInput = sc.nextInt();
			cpuInput = num.nextInt(3);
			if(cpuInput == 0)
			{
				System.out.println("CPU's move is: Rock");
			}
			else if(cpuInput == 1)
			{
				System.out.println("CPU's move is: Paper");
			}
			else
			{
				System.out.println("CPU's move is: Scissor");
			}
			
			if(userInput == cpuInput)
			{
				System.out.println("Its a draw");
			}
			else if (userInput == 0 && cpuInput == 1)
			{
				System.out.println("CPU WON!!!");
			}
			else if (userInput == 0 && cpuInput == 2)
			{
				System.out.println("YOU WON!!!");
			}
			else if (userInput == 1 && cpuInput == 0)
			{
				System.out.println("YOU WON!!!");
			}
			else if (userInput == 1 && cpuInput == 2)
			{
				System.out.println("CPU WON!!!");
			}
			else if(userInput == 2 && cpuInput == 0)
			{
				System.out.println("CPU WON !!!");
			}
			else
			{
				System.out.println("YOU WON!!!");
			}
			
			System.out.println("PLAY AGAIN (Y/N): ");
			playAgain = sc.next();
		}
		sc.close();
	}

}
