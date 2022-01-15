package Basic;

import java.util.Random;
import java.util.Scanner;

class Game{
	
	private int number;
	private int numOfGuess;
	private int userGuess;
	
	public Game()
	{
		Random num = new Random();
		this.number = num.nextInt(11);
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getNumOfGuess() {
		return numOfGuess;
	}
	
	public void setNumOfGuess(int numOfGuess) {
		this.numOfGuess = numOfGuess;
	}
	
	public void takeUserInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your guess (0-10)");
		this.userGuess = sc.nextInt();
		sc.close();
	}
	
	public void isCorrectNumber()
	{
		for(int i=0; i< this.numOfGuess; i++)
		{
			takeUserInput();
			if(userGuess == number)
			{
				System.out.println("WOW!! that is the correct number");
				break;
			}
			else if(i == numOfGuess-1)
			{
				System.out.println("SORRY YOU LOOSE");
			}
			else
			{
				System.out.println("WRONG GUESS Please try again...");
			}
		}
	}
	
}

public class CWH_GuessTheNumber {

	public static void main(String[] args) {
		Game g = new Game();
		System.out.println("Enter the number of guesses - ");
		Scanner sc = new Scanner(System.in);
		g.setNumOfGuess(sc.nextInt());
		g.isCorrectNumber();
		sc.close();
	}
}
