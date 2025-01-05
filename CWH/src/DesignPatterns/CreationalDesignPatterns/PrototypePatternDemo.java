package DesignPatterns;

import java.util.HashMap;

/* It is used in the systems where a large number if objects needs to be created and the 
 * cost of creating object with "new" instance is costly, so clone() method is used.
 * 
 * Link - https://www.geeksforgeeks.org/prototype-design-pattern/
 * 
 * Creational design patterns
 */

abstract class color implements Cloneable
{
	protected String colorName;
	
	abstract void addColor();
		
	// This is to override the clone() from Object class
	@Override
	protected Object clone()
	{
		Object obj = null;
		try
		{
			obj = super.clone();
		}
		catch(CloneNotSupportedException ex)
		{
			ex.printStackTrace();
		}
		return obj;
	}
}

class blueColor extends color
{
	public blueColor()
	{
		this.colorName = "blue";
	}
	
	@Override
	void addColor() {
		System.out.println("added color - " + colorName);
	}
}

class blackColor extends color
{
	public blackColor()
	{
		this.colorName = "black";
	}
	
	@Override
	void addColor() {
		System.out.println("added color - " + colorName);
	}
}

class ColorStore
{
	private static HashMap<String,color> map = new HashMap<String,color>();
	
	// create 2 fixed objects
	static
	{
		map.put("blue", new blueColor());
		map.put("black", new blackColor());
	}
	
	// keep cloning them when more objects are needed
	public static color getColor(String type)
	{
		return (color) map.get(type).clone();
	}
}

public class PrototypePatternDemo 
{
	public static void main(String[] args) {
		ColorStore.getColor("blue").addColor();
		ColorStore.getColor("blue").addColor();
		ColorStore.getColor("black").addColor();
		ColorStore.getColor("black").addColor();
	}
}
