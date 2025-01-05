package DesignPatterns.BehaviouralDesignPattern;
/* Used to provide loose coupling in the design where the same type of request can be handled 
 * by multiple handlers.
 * 
 * Below is an example where we will pass numbers to a chain of handlers.
 * Link - https://www.geeksforgeeks.org/chain-responsibility-design-pattern/
 * 
 * Behavioral Design Pattern
 * 
 * Use When -
 * Use them when your objects need to communicate in complicated ways.
 * Choose them when you want to easily change how things behave while the program is running.
 */

class Number
{
	private int num;
	
	public Number(int num)
	{
		this.num = num;
	}
	
	public int getNumber()
	{
		return num;
	}
}

// abstract Handler
abstract class Processor
{
	private Processor nextProcessor;
	
	public Processor(Processor nextProcessor)
	{
		this.nextProcessor  = nextProcessor;
	}
	
	public void process(Number num)
	{
		if(nextProcessor != null)
			nextProcessor.process(num);
	}
}

// concrete handlers
class PostiveProcessor extends Processor
{
	public PostiveProcessor(Processor nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void process(Number num)
	{
		if(num.getNumber()>=0)
		{
			System.out.println("Postive processor is processing - " + num.getNumber());
		}
		else
		{
			super.process(num);
		}
	}
}

class NegativeProcessor extends Processor
{
	public NegativeProcessor(Processor nextProcessor) {
		super(nextProcessor);
	}
	
	@Override
	public void process(Number num)
	{
		if(num.getNumber()<0)
		{
			System.out.println("Negative processor is processing - " + num.getNumber());
		}
		else
		{
			super.process(num);
		}
	}
}

//chain class
class Chain
{
	Processor chain;
	
	public Chain()
	{
		this.chain = new PostiveProcessor(new NegativeProcessor(null));
	}
	
	public void process(Number num)
	{
		chain.process(num);
	}
}

public class ChainOfResponsibilityPatternDemo 
{
	public static void main(String[] args) {
		Chain numProcessor = new Chain();
		
		numProcessor.process(new Number(10));
		numProcessor.process(new Number(-10));
		numProcessor.process(new Number(0));
	}
}
