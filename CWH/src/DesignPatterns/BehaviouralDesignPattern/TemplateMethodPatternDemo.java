package DesignPatterns;

/* Used popularly for framework development. Used to expose the skeleton of algorithm to 
 * the subclasses and let them define the partial functionalities but preserve the algorithm
 * flow with the parent.
 * 
 * Link - 	https://www.geeksforgeeks.org/template-method-design-pattern/
 * 
 * Behavioral Design Pattern
 */
abstract class OrderProcessTemplate
{
	protected boolean isGift;
	public abstract void doSelect();
	public abstract void doPayment();
	public final void wrapGift()
	{
		System.out.println("Wrapping as gift");
	}
	public abstract void doDelivery();
	// sequence in algorithm
	public final void processOrder()
	{
		doSelect();
		doPayment();
		if(isGift)
			wrapGift();
		doDelivery();
	}
}

class StoreOrder extends OrderProcessTemplate
{
	public StoreOrder(boolean isGift)
	{
		this.isGift = isGift;
	}

	@Override
	public void doSelect() {
		// TODO Auto-generated method stub
		System.out.println("Selecting gift");
	}

	@Override
	public void doPayment() {
		// TODO Auto-generated method stub
		System.out.println("Paying through Card/Cash");
	}

	@Override
	public void doDelivery() {
		// TODO Auto-generated method stub
		System.out.println("Delivery at the counter");
	}
	
}

public class TemplateMethodPatternDemo 
{
	public static void main(String[] args) {
		OrderProcessTemplate order1 = new StoreOrder(false);
		order1.processOrder();
		
		OrderProcessTemplate order2 = new StoreOrder(true);
		order2.processOrder();
	}
}
