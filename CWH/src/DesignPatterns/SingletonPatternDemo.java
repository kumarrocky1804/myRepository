package DesignPatterns;

/* This pattern ensures that there is only one instance of the class and no other class
 * can create multiple instances of this.
 * Links to read - https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
 * 	- https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
 * 
 * Below example is of Lazy initialization of singleton pattern
 * JVM has Runtime class using singleton pattern with early initialization
 * 
 * Creational design patterns
 */

class Singleton
{
	private static Singleton object;
	
	// eager or early initialization is to create object here only
	
	private Singleton()
	{}
	
	public static Singleton getInstance()
	{
		if(object==null)
		{
			synchronized(Singleton.class)
			{
				object = new Singleton();
			}
		}
		return object;
	}
}

public class SingletonPatternDemo 
{
	public static void main(String[] args) {
		//Singleton object1 = new Singleton(); //compilation error
		
		Singleton object1 = Singleton.getInstance();
		Singleton object2 = Singleton.getInstance();
		
		System.out.println(object1.hashCode());
		System.out.println(object2.hashCode());
	}
}
