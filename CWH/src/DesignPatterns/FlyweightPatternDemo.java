package DesignPatterns;

import java.util.HashMap;
import java.util.Random;

/* This pattern is used when we have to create a large number of similar objects.
 * Link - https://www.geeksforgeeks.org/flyweight-design-pattern/
 * 
 * Structural Design Pattern
 */

interface Player
{
	public void assignWeapon(String weapon);
	public void mission();
}

class Terrorist implements Player
{
	// intrinsic state - every terrorist will have same task
	private final String TASK;
	
	// extrinsic state - every terrorist will have different weapon
	private String weapon;
	
	public Terrorist()
	{
		TASK = "Plant the bomb";
	}
	
	@Override
	public void assignWeapon(String weapon)
	{
		this.weapon = weapon;
	}
	
	@Override
	public void mission()
	{
		System.out.println("Terrorist with weapon - " + weapon + "| going to - " + TASK);
	}
}

class CounterTerrorist implements Player
{
	// intrinsic state - every terrorist will have same task
	private final String TASK;
	
	// extrinsic state - every terrorist will have different weapon
	private String weapon;
	
	public CounterTerrorist()
	{
		TASK = "Defuse the bomb";
	}
	
	@Override
	public void assignWeapon(String weapon)
	{
		this.weapon = weapon;
	}
	
	@Override
	public void mission()
	{
		System.out.println("Counter Terrorist with weapon - " + weapon + "| going to - " + TASK);
	}
}

// Flywight pattern factory that will reuse 2 objects 
class PlayerFactory
{
	private static HashMap<String,Player> map = 
			new HashMap<String,Player>();
			
	public static Player getPlayer(String type)
	{
		Player p = null;
		
		// if object of this type is created before this, then return the same object
		if(map.containsKey(type))
			p = map.get(type);
		else
		{
			if("terrorist".equalsIgnoreCase(type))
			{
				System.out.println("New Terrorist object created");
				p = new Terrorist();
			}
			else if("CounterTerrorist".equalsIgnoreCase(type))
			{
				System.out.println("New Counter Terrorist object created");
				p = new CounterTerrorist();
			}
			map.put(type, p);
		}
		return p;
	}
}

public class FlyweightPatternDemo 
{
	private static String[] playerType = {"Terrorist","CounterTerrorist"};
	private static String[] weaponType = 
		{"Gun", "Hammer", "Iron Rod", "Swiss Knife"};
	
	public static String getRandomPlayerType()
	{
		return playerType[new Random().nextInt(playerType.length)];
	}
	
	public static String getRandomWeapon()
	{
		return weaponType[new Random().nextInt(weaponType.length)];
	}
	
	public static void main(String[] args) 
	{
		//ten random players with random weapons
		for(int i=0; i<10; i++)
		{
			Player p = PlayerFactory.getPlayer(getRandomPlayerType());
			
			p.assignWeapon(getRandomWeapon());
			
			p.mission();
		}
	}
}
