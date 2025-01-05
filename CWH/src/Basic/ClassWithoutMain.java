package Basic;

public class ClassWithoutMain 
{
	public ClassWithoutMain() {
		System.out.println("I am the constructor");
	}
	// Until java 6 it was allowed to have class without main by creating static block
	// but since java 7, JVM looks for main method explicitly even if it is empty.
	{
		System.out.println("Normal block");
	}
	static {
		System.out.println("static block -");
	}	
	
	/*public static void main(String[] args)
	{
		// static block called before this.
		System.out.println("Hello from main block");
		// non static block called after above and before constructor
		ClassWithoutMain obj = new ClassWithoutMain();
	}*/
}
