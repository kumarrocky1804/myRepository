package Basic;

abstract class Pen
{
	abstract void write();
	abstract void refill();
}

class FountainPen extends Pen
{
	@Override
	void write() {
		System.out.println("Fountain Pen is writting");
	}

	@Override
	void refill() {
		System.out.println("Fountain Pen is refilling");
	}
	
	void ChangeNib()
	{
		System.out.println("Fountain Pen is changing Nib");
	}
}

class Monkey
{
	public void jump()
	{
		System.out.println("Monkey Jumps.");
	}
	
	public void bite()
	{
		System.out.println("Monkey Bites");
	}
}

interface BasicHuman
{
	void eat();
	void sleep();
}

class Human extends Monkey implements BasicHuman
{
	@Override
	public void jump()
	{
		super.jump();
		System.out.println("Now jump as human");
	}
	@Override
	public void eat() {
		System.out.println("Human eats");
		
	}

	@Override
	public void sleep() {
		System.out.println("Human sleeps");
	}
	
}

interface TVRemote
{
	void changeChannel();
	default void greet()
	{
		System.out.println("I was added in JDK 8 so that the class already imple"
				+ "nting me do not have to change (backward compatibility)");
	}
	
}

interface SmartTVRemote extends TVRemote
{
	void SwitchToNetflix();
}

class TV implements SmartTVRemote
{

	@Override
	public void changeChannel() {
		System.out.println("Playing SONY");
		
	}

	@Override
	public void SwitchToNetflix() {
		System.out.println("Playing Netflix");
		
	}
	
}

public class CWH_AbstractClassAndInterfaces {
	public static void main(String[] args) {
		/*Pen pen = new FountainPen();
		pen.write();
		pen.refill();*/
		//pen.ChangeNib(); // NOT ALLOWED
		
		/*FountainPen pen = new FountainPen();
		pen.write();
		pen.refill();
		pen.ChangeNib();*/
		
		Human h = new Human();
		h.bite();
		h.eat();
		h.sleep();
		h.jump();
		
		BasicHuman b = new Human();
		b.eat();
		b.sleep();
		//b.jump(); // NOT ALLOWED
		//b.bite(); // NOT ALLOWED
	}
}
