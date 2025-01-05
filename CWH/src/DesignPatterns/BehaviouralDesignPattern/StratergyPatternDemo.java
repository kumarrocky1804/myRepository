package DesignPatterns.BehaviouralDesignPattern;
/* Also called Policy pattern - 
 * In computer programming, the strategy pattern (also known as the policy pattern) is a 
 * software design pattern that enables an algorithm’s behavior to be selected at runtime.
 * Link - https://www.geeksforgeeks.org/strategy-pattern-set-2/
 * 
 * Here, we will implement an athlete that can do Long jump or High Jump at runTime.
 * 
 * Behavioral Design Pattern
 */

// policy pattern family interface
interface jumping
{
	public void jump();
}

// Differnt policies that belong to same family
class highJump implements jumping
{
	@Override
	public void jump()
	{
		System.out.println("Doing high jump");
	}
}

class longJump implements jumping
{
	@Override
	public void jump()
	{
		System.out.println("Doing long jump");
	}
}

class athlete
{
	jumping jump;
	
	public void punch()
	{
		System.out.println("punching...");
	}
	
	public void jump()
	{
		jump.jump();
	}

	public void setJump(jumping jump) {
		this.jump = jump;
	}
}

public class StratergyPatternDemo 
{
	public static void main(String[] args) {
		athlete me = new athlete();
		longJump longJump = new longJump();
		highJump highJump = new highJump();
		me.setJump(longJump);
		me.jump();
		
		me.setJump(highJump);
		me.jump();
	}
}
