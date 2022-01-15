package Basic;

class Base
{
	{
		System.out.println("I am a block");
	}
	public Base()
	{
		System.out.println("I am base class constructor");
	}
	
	public void fun()
	{
		System.out.println("Fun() of base class");
	}
}

class Derived1 extends Base
{
	public int publicProperty;
	private int privateProperty;
	protected int protectedProperty;
	int DefaultProperty;
	final int FinalProperty=0;
	static int StaticProperty;
	
	public Derived1()
	{
		System.out.println("I am derived1 class constructor");
	}
	
	@Override
	public void fun()
	{
		System.out.println("Fun() of derived1 class");
	}
}

class Derived2 extends Derived1
{
	public Derived2()
	{
		System.out.println("I am dervide2 class constructor");
	}
	
	public void newFun()
	{
		System.out.println("I am new function of derived2 class");
	}
}

public class CWH_Inheritance {

	public static void main(String[] args) {
		// Derived2 obj = (Derived2) new Derived1(); //will compile but ClassCastException
		//Derived1 obj = new Derived2(); //Allowed and will run
		
		//Base obj = new Derived2();
		//obj.fun(); //fun() of derived1 class 
		//obj.newFun(); // NOT ALLOWED
		
		Derived2 obj = new Derived2();
		obj.fun();
		obj.newFun();
		
		/* static, final and private members have static binding and
		 * also there are not overridden */
		
		System.out.println(obj.DefaultProperty + obj.FinalProperty + obj.StaticProperty
				+ obj.protectedProperty + obj.publicProperty);
	}
}
