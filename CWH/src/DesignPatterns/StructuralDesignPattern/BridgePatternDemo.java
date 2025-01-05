package DesignPatterns.StructuralDesignPattern;
/* Used to decouple the abstraction and implementation
 * Link - https://www.geeksforgeeks.org/bridge-design-pattern/
 * 
 * Structural Design Pattern
 */

// abstraction
abstract class vehicle
{
	protected Workshop workshop1;
	protected Workshop workshop2;
	
	protected vehicle(Workshop workshop1, Workshop workshop2)
	{
		this.workshop1 = workshop1;
		this.workshop2 = workshop2;
	}
	
	abstract void manufacture();
}

class Car extends vehicle
{
	public Car(Workshop workshop1, Workshop workshop2)
	{
		super(workshop1, workshop2);
	}
	
	@Override
	public void manufacture()
	{
		System.out.println("Manufacturing car - ");
		workshop1.work();
		workshop2.work();
	}
}

// implementation
interface Workshop
{
	public void work();
}

class ProduceParts implements Workshop
{
	@Override
	public void work() 
	{
		System.out.println("Producing Parts in the workshop - ProduceParts");
	}
}

class Assemble implements Workshop
{
	@Override
	public void work() 
	{
		System.out.println("Assembling Parts in the workshop - Assemble");
	}
}

public class BridgePatternDemo 
{
	public static void main(String[] args) {
		// Loose coupled abstraction and implementation binding
		vehicle car = new Car(new ProduceParts(), new Assemble());
		
		car.manufacture();
	}
}
