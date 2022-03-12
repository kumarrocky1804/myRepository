package Basic;

// Basic enum
enum color
{
	RED,GREEN,ORANGE,YELLOW;
}

// ENum with custom values
enum Fruit
{
	APPLE(color.RED),
	GRAPE(color.GREEN),
	ORANGE(color.ORANGE),
	BANANA(color.YELLOW);
	
	private color c;
	
	// getter method
	public color getColor()
	{
		return this.c;
	}
	
	//constructor - cannot be public or protected as multiple objects are not needed for enums
	private Fruit(color c)
	{
		System.out.println("COnstructor called for - " + this.toString());
		this.c = c;
	}
}

/* ENum extends java.lang.enum class
 * THE above enum is converted to following 
 * class implicitly by the compiler
 * 
enum Fruit
{
	public static final APPLE = new Fruit("RED");
	public static final GRAPE = new Fruit ("GREEN");
	public static final ORANGE = new Fruit ("ORANGE");
	public static final BANANA = new Fruit ("YELLOW");
	
	private String action;
	
	// getter method
	public String getAction()
	{
		return this.action;
	}
	
	//constructor - cannot be public or protected as multiple objects are not needed for enums
	private Fruit(String action)
	{
		this.action = action;
	}
}
 */

public class EnumsInJava
{
	public static void main(String[] args) 
	{
		Fruit[] fruits = Fruit.values();
		
		for(Fruit fruit: fruits)
		{
			System.out.println("INDEX - " + fruit.ordinal() + " NAME - " + fruit.name() +
						" COLOR - " + fruit.getColor());
		}
	}
}
