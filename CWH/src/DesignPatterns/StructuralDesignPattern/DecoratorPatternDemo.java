package DesignPatterns.StructuralDesignPattern;

/* This pattern is used when we want to enhance the selected object's functionality or 
 * enhance the object without changing its behavior
 * 
 * Ex- Pizza toppings addition without changing pizza class
 *  - Shape decorators (below implemented)
 *  
 *  Link - https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/
 *  
 *  Structural Design Pattern
 */

interface Shape
{
	public void draw();
}

class circle implements Shape
{
	@Override
	public void draw() 
	{
		System.out.println("Drawn a circle");
	}	
}

// Abstract decorator class which can be extended to add multiple decorators
abstract class ShapeDecorator implements Shape
{
	protected Shape shape;
	
	public ShapeDecorator(Shape shape)
	{
		this.shape = shape;
	}
}

// One example of concrete decorator
class RedBorder extends ShapeDecorator
{
	public RedBorder(Shape shape)
	{
		super(shape);
	}

	@Override
	public void draw() 
	{
		shape.draw();
		System.out.println("Added border color - red");
	}
}


public class DecoratorPatternDemo 
{
	public static void main(String[] args) {
		Shape shape = new circle();
		shape.draw();
		
		Shape shape2 = new RedBorder(new circle());
		shape2.draw();
		
		new RedBorder(shape).draw();
	}
}
