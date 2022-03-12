package Basic;

public class ClassWithoutMain 
{
	// Until java 6 it was allowed to have class without main by creating static block
	// but since java 7, JVM looks for main method explicitly even if it is empty.
	{
		System.out.println("Normal block");
	}
	static {
		System.out.println("static block -");
	}
}
